package com.adaming.myapp.service;

import java.util.List;

import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.entities.Operation;
import com.adaming.myapp.exceptions.OperationExistanteException;
import com.adaming.myapp.exceptions.SoldeInsuffisantException;

public interface IOperationService {
	
	 Operation save(Operation entity);
	
	 Operation update(Operation entity) throws OperationExistanteException;
	
	 Operation getOne(Long id) throws OperationExistanteException;
	
	 List<Operation> getAll();
	
	 Operation save(Operation operation, Long idEmploye, Long idCompte);
	
	 Operation remove(Long id) throws OperationExistanteException;
	
	 Operation versement(Long idCompteC, Long idEmploye, Double montant);
	
	 Operation retrait(Long idCompteD, Long idEmploye, Double montant) throws SoldeInsuffisantException;
	
	 Operation virement(Long idCompteD, Long idCompteC, Long idEmploye, Double montant) throws SoldeInsuffisantException;

	 Compte getCompte(Long id);
	 
}
	
