package com.adaming.myapp.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.dao.ICompteDao;
import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.exceptions.CompteExistantException;
import com.adaming.myapp.exceptions.GroupeExistantException;

@Transactional
public class CompteServiceImpl implements ICompteService{
	
	private ICompteDao cdao;

	private final Logger LOGGER  = Logger.getLogger("CompteServiceImpl");
	
	
	
	public void setCdao(ICompteDao cdao) {
		LOGGER.info("<---------- dao injected------->");
		this.cdao = cdao;
	}

	@Override
	public Compte save(Compte entity) {
		LOGGER.info("Le compte a bien été créé");
		return cdao.save(entity);
	}

	@Override
	public Compte update(Compte entity) throws CompteExistantException {
		List<Compte> comptes = getAll();
		int i = 0;
		for (Compte c1 : comptes){
			if(c1.getId()==entity.getId()){
				i++;
			}
		}
		if (i==0){
			throw new CompteExistantException("Le compte n'existe pas");}
		else{
			LOGGER.info("Le compte a bien été sauvegardé");
			return cdao.update(entity);	
		}
	}

	@Override
	public Compte getOne(Long id) throws CompteExistantException {
		List<Compte> comptes = getAll();
		int i = 0;
		for (Compte c1 : comptes){
			if(c1.getId()==id){
				i++;
			}
		}
		if (i==0){
			throw new CompteExistantException("Le compte n'existe pas");}
		else{
			return cdao.getOne(id);
		}
	}

	@Override
	public List<Compte> getAll() {
		// TODO Auto-generated method stub
		return cdao.getAll();
	}

	@Override
	public Compte remove(Long id) throws CompteExistantException {
		List<Compte> comptes = getAll();
		int i = 0;
		for (Compte c1 : comptes){
			if(c1.getId()==id){
				i++;
			}
		}
		if (i==0){
			throw new CompteExistantException("Le compte n'existe pas");}
		else{
			LOGGER.info("Le compte a bien été supprimé");
			return cdao.remove(id);
		}
	}

	@Override
	public List<Compte> getCompteByClient(Long idClient) throws CompteExistantException {
		// TODO Auto-generated method stub
		List<Compte> comptes = getAll();
		int i = 0;
		for (Compte c1 : comptes){
			if(c1.getClient().getId()==idClient){
				i++;
			}
		}
		if (i==0){
			throw new CompteExistantException("Le compte n'existe pas");}
		else{
			return cdao.getCompteByClient(idClient);
		}
		
	}

	@Override
	public List<Compte> getCompteByEmploye(Long idEmploye) throws GroupeExistantException {
		List<Compte> comptes = getAll();
		// TODO Auto-generated method stub
		int i = 0;
		for (Compte c1 : comptes){
			if(c1.getEmploye().getId()==idEmploye){
				i++;
			}
		}
		if (i==0){
			throw new GroupeExistantException("L'employé n'existe pas");}
		else{
			return cdao.getCompteByEmploye(idEmploye);
		}
	}

}
