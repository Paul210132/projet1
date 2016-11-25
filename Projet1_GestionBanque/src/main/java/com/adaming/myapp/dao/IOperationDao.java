package com.adaming.myapp.dao;

import com.adaming.myapp.entities.*;
import com.adaming.myapp.persistence.IGenericDao;

public interface IOperationDao extends IGenericDao<Operation>{
	
	public Operation save(Operation operation, Long idEmploye, Long idCompte);
	
	public Compte getCompte(Long id);
	
	
}
