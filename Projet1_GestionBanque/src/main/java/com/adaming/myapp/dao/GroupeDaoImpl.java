package com.adaming.myapp.dao;

import java.util.List;

import com.adaming.myapp.entities.*;
import com.adaming.myapp.persistence.AbstractJPA;

public class GroupeDaoImpl extends AbstractJPA<Groupe> implements IGroupeDao{

	@Override
	public Groupe save(Groupe entity) {
		// TODO Auto-generated method stub
		return saveAbstractJpa(entity);
	}

	@Override
	public Groupe update(Groupe entity) {
		// TODO Auto-generated method stub
		return updateAbstractJpa(entity);
	}

	@Override
	public Groupe getOne(Long id) {
		// TODO Auto-generated method stub
		return getOneAbstractJpa(id);
	}

	@Override
	public List<Groupe> getAll() {
		// TODO Auto-generated method stub
		return getAllAbstractJpa();
	}

	@Override
	public Groupe remove(Long id) {
		// TODO Auto-generated method stub
		return removeAbstractJpa(id);
	}

	@Override
	public Employe addEmploye(Long idGroupe, Long idEmploye) {
		Employe employe = em.find(Employe.class, idEmploye);
		Groupe groupe = em.find(Groupe.class, idGroupe);
		groupe.getEmployes().add(employe);
		return employe;
	}

}
