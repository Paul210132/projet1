package com.adaming.myapp.persistence;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao <T extends Serializable>{

	T save(final T entity);
	
	T update(final T entity);
	
	T getOne(final Long id);
	
	List<T> getAll();
	
	T remove(final Long id);
	
}
