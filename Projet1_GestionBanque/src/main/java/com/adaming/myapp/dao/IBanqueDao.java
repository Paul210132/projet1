package com.adaming.myapp.dao;

import java.util.List;

import com.adaming.myapp.entities.Banque;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.persistence.IGenericDao;

public interface IBanqueDao extends IGenericDao<Banque>{
	
	public Banque AddCompteToBanque(Compte c, Long idBanque);
	
	public Banque AddClientToBanque(Client c, Long idBanque);
	
	public Banque AddEmployeToBanque(Employe e, Long idBanque);
	
}
