 package com.adaming.myapp.dao;

import java.util.List;

import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.persistence.AbstractJPA;

public class CompteDaoImpl extends AbstractJPA<Compte>implements ICompteDao{

	@Override
	public Compte save(Compte entity) {
		// TODO Auto-generated method stub
		return saveAbstractJpa(entity);
	}

	@Override
	public Compte update(Compte entity) {
		// TODO Auto-generated method stub
		return updateAbstractJpa(entity);
	}

	@Override
	public Compte getOne(Long id) {
		// TODO Auto-generated method stub
		return getOneAbstractJpa(id);
	}

	@Override
	public List<Compte> getAll() {
		// TODO Auto-generated method stub
		return getAllAbstractJpa();
	}

	@Override
	public Compte remove(Long id) {
		// TODO Auto-generated method stub
		return removeAbstractJpa(id);
	}

	@Override
	public List<Compte> getCompteByClient(Long idClient) {
		Client client = em.find(Client.class, idClient);
		return client.getComptes();
	}

	@Override
	public List<Compte> getCompteByEmploye(Long idEmploye) {
		Employe employe = em.find(Employe.class, idEmploye);
		return employe.getComptes();
		
	}

	@Override
	public Compte save(Compte c, Long idEmploye, Long idClient) {

		Employe employe = em.find(Employe.class, idEmploye);
		Client client = em.find(Client.class, idClient);
		c.setEmploye(employe);
		c.setClient(client);
		
		return c;
	}

	

	

}
