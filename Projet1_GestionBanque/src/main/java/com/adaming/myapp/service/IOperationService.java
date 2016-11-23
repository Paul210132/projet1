package com.adaming.myapp.service;

import java.util.List;

import com.adaming.myapp.entities.Operation;
import com.adaming.myapp.exceptions.OperationExistanteException;
import com.adaming.myapp.exceptions.SoldeInsuffisantException;

public interface IOperationService {
	
	public Operation save(Operation entity);
	
	public Operation update(Operation entity) throws OperationExistanteException;
	
	public Operation getOne(Long id) throws OperationExistanteException;
	
	public List<Operation> getAll();
	
	public Operation remove(Long id) throws OperationExistanteException;
	
	public Operation versement(Long idCompteC, Long idEmploye, Double montant);
	
	public Operation retrait(Long idCompteD, Long idEmploye, Double montant) throws SoldeInsuffisantException;
	
	public Operation virement(Long idCompteD, Long idCompteC, Long idEmploye, Double montant) throws SoldeInsuffisantException;
}
	
