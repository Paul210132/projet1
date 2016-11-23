package com.adaming.myapp.service;

import java.util.List;

import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.entities.Groupe;
import com.adaming.myapp.exceptions.GroupeExistantException;

public interface IGroupeService {
	
	public Groupe save(Groupe entity);
	public Groupe update(Groupe entity) throws GroupeExistantException;
	public Groupe getOne(Long id) throws GroupeExistantException;
	public List<Groupe> getAll();
	public Groupe remove(Long id) throws GroupeExistantException;
	public Employe addEmploye(Long idGroupe, Long idEmploye) throws GroupeExistantException;

}
