package com.adaming.myapp.dao;

import com.adaming.myapp.entities.*;
import com.adaming.myapp.persistence.IGenericDao;

public interface IGroupeDao extends IGenericDao<Groupe>{

	Employe addEmploye(Long idGroupe, Long idEmploye);
	
}
