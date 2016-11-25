package com.adaming.myapp.service;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.dao.IOperationDao;
import com.adaming.myapp.entities.*;
import com.adaming.myapp.exceptions.OperationExistanteException;
import com.adaming.myapp.exceptions.SoldeInsuffisantException;

@Transactional
public class OperationServiceImpl implements IOperationService{
	
	private IOperationDao dao;
	private final Logger LOGGER  = Logger.getLogger("OperationServiceImpl");
	Date date = new Date();
	
	public void setDao(IOperationDao dao) {
		LOGGER.info("<---------- dao injected------->");
		this.dao = dao;
	}
	
	@Override
	public Operation save(Operation entity) {
		LOGGER.info("<---------- Operation added------->");
		return dao.save(entity);
	}
	
	@Override
	public Operation save(Operation operation, Long idEmploye, Long idCompte) {
		LOGGER.info("<---------- Operation associated to Employe and Compte------->");
		return dao.save(operation, idEmploye, idCompte);
	}	
	
	@Override
	public Operation update(Operation entity) throws OperationExistanteException {
		int i = 0;
		List<Operation> operations = getAll();
        for (Operation c1 : operations){
            if(c1.getId()==entity.getId()){
                i++;
            }
        }
        if (i==0){
            throw new OperationExistanteException("L'opération n'existe pas");
            }
        else{
        	LOGGER.info("<---------- Operation updated------->");
        	return dao.update(entity);
        }
	}

	@Override
	public Operation getOne(Long id) throws OperationExistanteException {
		int i = 0;
		List<Operation> operations = getAll();
        for (Operation c1 : operations){
            if(c1.getId()==id){
                i++;
            }
        }
        if (i==0){
            throw new OperationExistanteException("L'opération n'existe pas");}
        else{
        	LOGGER.info("<---------- Operation read------->");
        	return dao.getOne(id);
        }
	}

	@Override
	public List<Operation> getAll() {
		LOGGER.info("<---------- Operation readAll------->");
		return dao.getAll();
	}

	@Override
	public Operation remove(Long id) throws OperationExistanteException {
		int i = 0;
		List<Operation> operations = getAll();
        for (Operation c1 : operations){
            if(c1.getId()==id){
                i++;
            }
        }
        if (i==0){
            throw new OperationExistanteException("L'opération n'existe pas");}
        else{
        	LOGGER.info("<---------- Operation deleted------->");
        	return dao.remove(id);
	}
	}

	@Override
	public Operation versement(Long idCompteC, Long idEmploye, Double montant) {
		Operation o = new Versement(date, montant);
		LOGGER.info("<---------- Versement instancié- Montant = "+montant+"------>");
		dao.save(o, idEmploye, idCompteC);
		LOGGER.info("<---------- Versement associé- Employe = "+idEmploye+"---Compte = "+idCompteC+"--->");
		Compte compteC = dao.getCompte(idCompteC);
		compteC.setSolde(compteC.getSolde()+montant);
		LOGGER.info("<---------- Nouveau Solde = "+compteC.getSolde()+"€------>");
		
		return o;
	}

	@Override
	public Operation retrait(Long idCompteD, Long idEmploye, Double montant) throws SoldeInsuffisantException {
		Operation o = new Versement(date, montant);
		dao.save(o, idEmploye, idCompteD);
		Compte compteD = dao.getCompte(idCompteD);
		Double nouveauSolde = compteD.getSolde() - montant;
		if(compteD.getClass().getSimpleName().equals("CompteCourant"))
		{
			Double decouvert = compteD.getCalcul();
			
			boolean b = nouveauSolde > decouvert;
			LOGGER.info("decouvert = €"+decouvert+" | nouveauSolde > decouvert :"+b);
			if(nouveauSolde > decouvert)
			{
				compteD.setSolde(nouveauSolde);
			}
			else{
				throw new SoldeInsuffisantException("Le solde de ce compte est insuffisant pour traiter cette opération");
			}
		}
		else if(compteD.getClass().getSimpleName().equals("CompteEpargne"))
		{
			if(nouveauSolde > 0)
			{
				compteD.setSolde(nouveauSolde);
			}
			else{
				throw new SoldeInsuffisantException("Les découverts ne sont pas autorisés sur un compte épargne");
			}
		}
		return o;
	}

	@Override
	public Operation virement(Long idCompteD, Long idCompteC, Long idEmploye, Double montant) throws SoldeInsuffisantException {
		Operation o = new Virement(date, montant);
		LOGGER.info("<-------------Instanciation Virement --------------->");
		versement(idCompteC, idEmploye, montant);
		LOGGER.info("<-------------Credit CompteC --------------->");
		retrait(idCompteD, idEmploye, montant);
		LOGGER.info("<-------------Debit CompteD --------------->");
		return o;
	}

	@Override
	public Compte getCompte(Long id) {
		// TODO Auto-generated method stub
		return dao.getCompte(id);
	}

	
}
