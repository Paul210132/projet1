package com.adaming.myapp.dao;

import java.util.List;

import com.adaming.myapp.entities.*;
import com.adaming.myapp.persistence.AbstractJPA;

public class EmployeDaoImpl extends AbstractJPA<Employe> implements IEmployeDao{

	@Override
	public Employe save(Employe entity) {
		// TODO Auto-generated method stub
		return saveAbstractJpa(entity);
	}

	@Override
	public Employe update(Employe entity) {
		// TODO Auto-generated method stub
		return updateAbstractJpa(entity);
	}

	@Override
	public Employe getOne(Long id) {
		// TODO Auto-generated method stub
		return getOneAbstractJpa(id);
	}

	@Override
	public List<Employe> getAll() {
		// TODO Auto-generated method stub
		return getAllAbstractJpa();
	}

	@Override
	public Employe remove(Long id) {
		// TODO Auto-generated method stub
		return removeAbstractJpa(id);
	}

	@Override
	public List<Employe> getEmploye(Long idGroupe) {
		Groupe groupe = em.find(Groupe.class, idGroupe);
		return groupe.getEmployes();
	}

	@Override
	public Groupe getGroupe(Long idGroupe) {
		Groupe groupe = em.find(Groupe.class, idGroupe);
		return groupe;
	}

}
