package com.adaming.myapp.dao;

import java.util.List;

import com.adaming.myapp.entities.Operation;
import com.adaming.myapp.persistence.AbstractJPA;

public class OperationDaoImpl extends AbstractJPA<Operation> implements IOperationDao{

	@Override
	public Operation save(Operation entity) {
		// TODO Auto-generated method stub
		return saveAbstractJpa(entity);
	}

	@Override
	public Operation update(Operation entity) {
		// TODO Auto-generated method stub
		return updateAbstractJpa(entity);
	}

	@Override
	public Operation getOne(Long id) {
		// TODO Auto-generated method stub
		return getOneAbstractJpa(id);
	}

	@Override
	public List<Operation> getAll() {
		// TODO Auto-generated method stub
		return getAllAbstractJpa();
	}

	@Override
	public Operation remove(Long id) {
		// TODO Auto-generated method stub
		return removeAbstractJpa(id);
	}

}
