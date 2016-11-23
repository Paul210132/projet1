package com.adaming.myapp.dao;

import java.util.List;

import com.adaming.myapp.entities.Banque;
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

	

}
