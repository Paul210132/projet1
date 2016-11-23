package com.adaming.myapp.dao;

import java.util.List;

import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.entities.Operation;
import com.adaming.myapp.persistence.AbstractJPA;

public class OperationDaoImpl extends AbstractJPA<Operation> implements IOperationDao{

	
	public Operation save(Operation operation, Long idEmploye, Long idCompte) {
		
		Employe employe = em.find(Employe.class, idEmploye);
		Compte compte = em.find(Compte.class, idCompte);
		
		operation.setEmploye(employe);
		operation.getComptes().add(compte);
		
		return saveAbstractJpa(operation);
	}

	@Override
	public Operation update(Operation entity) {
		// TODO Auto-generated method stub
		return updateAbstractJpa(entity);
	}

	@Override
	public Operation getOne(Long id) {
		// TODO Auto-generated method stub
		return getOneAbstractJpa(id);
	}

	@Override
	public List<Operation> getAll() {
		// TODO Auto-generated method stub
		return getAllAbstractJpa();
	}

	@Override
	public Operation remove(Long id) {
		// TODO Auto-generated method stub
		return removeAbstractJpa(id);
	}

	@Override
	public Operation save(Operation entity) {
		// TODO Auto-generated method stub
		return saveAbstractJpa(entity);
	}

	@Override
	public Compte getCompte(Long id) {
		Compte c = em.find(Compte.class, id);
		return c;
	}
	
}
