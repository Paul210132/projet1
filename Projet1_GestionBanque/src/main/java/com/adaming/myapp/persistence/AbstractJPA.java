package com.adaming.myapp.persistence;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractJPA<T extends Serializable>{
    
	@PersistenceContext
	protected EntityManager em;
	
	private Class <T> cl;
	@SuppressWarnings("unchecked")
	public AbstractJPA() {
		this.cl = (Class <T> )(  (ParameterizedType)  (getClass().getGenericSuperclass())).getActualTypeArguments()[0];
	}
    public T saveAbstractJpa(T entity){
    	em.persist(entity);
    	return entity;
    }
	
	public T updateAbstractJpa(T entity){
		em.merge(entity);
		return entity;
	}
	
	public T getOneAbstractJpa(final Long id){
		T t = em.find(cl,id);
		return t;
	}
	@SuppressWarnings("unchecked")
	public List<T> getAllAbstractJpa(){
		return em.createQuery("from "+cl.getName()).getResultList();
	}
	
	public T removeAbstractJpa(final Long id){
		T t = getOneAbstractJpa(id);
		em.remove(t);
		return t;
	}
	
	
	
}
