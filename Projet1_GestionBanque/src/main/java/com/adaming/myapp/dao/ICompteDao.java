package com.adaming.myapp.dao;

import java.util.List;

import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.persistence.IGenericDao;

public interface ICompteDao extends IGenericDao<Compte>{
	
	public List<Compte> getCompteByClient(Long idClient);
	public List<Compte> getCompteByEmploye(Long idEmploye);

}
