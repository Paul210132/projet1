package com.adaming.myapp.dao;

import java.util.List;

import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.persistence.IGenericDao;

public interface IClientDao extends IGenericDao<Client> {
	
	List<Client> getClient(String mc);
	
	Client AddCompteToClient(Compte c, Long idClient);

}
