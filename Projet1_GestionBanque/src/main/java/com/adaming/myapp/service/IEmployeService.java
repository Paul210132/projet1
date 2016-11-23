package com.adaming.myapp.service;

import java.util.List;

import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.exceptions.EmployeExistantException;

public interface IEmployeService {

	public Employe save(Employe entity);
	
	public Employe update(Employe entity) throws EmployeExistantException;
	
	public Employe getOne(Long id) throws EmployeExistantException;
	
	public List<Employe> getAll();
	
	public Employe remove(Long id) throws EmployeExistantException;
	
	public List<Employe> getEmploye(Long idGroupe) throws EmployeExistantException;
	
	
}
