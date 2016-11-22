package com.adaming.myapp.dao;

import java.util.List;

import com.adaming.myapp.entities.*;
import com.adaming.myapp.persistence.IGenericDao;

public interface IEmployeDao extends IGenericDao<Employe>{

	List<Employe> getEmploye(Long idGroupe);
	
}
