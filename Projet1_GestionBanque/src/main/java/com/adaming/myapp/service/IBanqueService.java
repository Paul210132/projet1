package com.adaming.myapp.service;

import java.util.List;

import com.adaming.myapp.entities.Banque;
import com.adaming.myapp.exceptions.BanqueExistanteException;
import com.adaming.myapp.exceptions.ClientExistantException;

public interface IBanqueService {

	public Banque save(Banque entity) throws BanqueExistanteException;;

	public Banque update(Banque entity) throws BanqueExistanteException;

	public Banque getOne(Long id) throws BanqueExistanteException;

	public List<Banque> getAll();

	public Banque remove(Long id);
	
}
