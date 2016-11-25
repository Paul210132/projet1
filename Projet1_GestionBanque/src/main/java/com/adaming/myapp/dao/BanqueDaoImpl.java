package com.adaming.myapp.dao;

import java.util.List;

import com.adaming.myapp.entities.Banque;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.persistence.AbstractJPA;

public class BanqueDaoImpl extends AbstractJPA<Banque> implements IBanqueDao{

	
	@Override
	public Banque save(Banque entity) {
		// TODO Auto-generated method stub
		return saveAbstractJpa(entity);
	}

	@Override
	public Banque update(Banque entity) {
		// TODO Auto-generated method stub
		return updateAbstractJpa(entity);
	}

	@Override
	public Banque getOne(Long id) {
		// TODO Auto-generated method stub
		return getOneAbstractJpa(id);
	}

	@Override
	public List<Banque> getAll() {
		// TODO Auto-generated method stub
		return getAllAbstractJpa();
	}

	@Override
	public Banque remove(Long id) {
		// TODO Auto-generated method stub
		return removeAbstractJpa(id);
	}

	@Override
	public Banque AddCompteToBanque(Compte c, Long idBanque) {
		Banque b = em.find(Banque.class,idBanque);
		System.out.println("bla1");
		b.getComptes().add(c);
		System.out.println("bla2");
		return saveAbstractJpa(b);
	}

	@Override
	public Banque AddClientToBanque(Client c, Long idBanque) {
		Banque b = em.find(Banque.class,idBanque);
		b.getClients().add(c);
		return saveAbstractJpa(b);
	}

	@Override
	public Banque AddEmployeToBanque(Employe e, Long idBanque) {
		Banque b = em.find(Banque.class,idBanque);
		b.getEmployes().add(e);
		return saveAbstractJpa(b);
	}

}
