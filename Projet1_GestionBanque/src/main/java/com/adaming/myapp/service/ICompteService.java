package com.adaming.myapp.service;

import java.util.List;

import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.exceptions.CompteExistantException;
import com.adaming.myapp.exceptions.GroupeExistantException;

public interface ICompteService {
	
	
	public Compte save(Compte entity);
	public Compte update(Compte entity) throws CompteExistantException;
	public Compte getOne(Long id)throws CompteExistantException;
	public List<Compte> getAll();
	public Compte remove(Long id)throws CompteExistantException;
	public List<Compte> getCompteByClient(Long idClient) throws CompteExistantException;
	public List<Compte> getCompteByEmploye(Long idEmploye) throws GroupeExistantException;
		
	}
