package com.adaming.myapp.dao;

import java.util.List;

import javax.persistence.Query;

import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.persistence.AbstractJPA;

public class ClientDaoImpl extends AbstractJPA<Client> implements IClientDao{


	@Override
	public Client save(Client entity) {
		// TODO Auto-generated method stub
		return saveAbstractJpa(entity);
	}

	@Override
	public Client update(Client entity) {
		// TODO Auto-generated method stub
		return updateAbstractJpa(entity);
	}

	@Override
	public Client getOne(Long id) {
		// TODO Auto-generated method stub
		return getOneAbstractJpa(id);
	}

	@Override
	public List<Client> getAll() {
		// TODO Auto-generated method stub
		return getAllAbstractJpa();
	}

	@Override
	public Client remove(Long id) {
		// TODO Auto-generated method stub
		return removeAbstractJpa(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> getClient(String mc) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from Client c where c.nom like :x");
		query.setParameter("x","%"+mc+"%");
		return query.getResultList();
	}

	@Override
	public Client AddCompteToClient(Compte cp, Long idClient) {
		Client cli = em.find(Client.class,idClient);
		cli.getComptes().add(cp);
		return saveAbstractJpa(cli);
	}

}

