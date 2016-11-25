package com.adaming.myapp.service;

import java.util.List;

import com.adaming.myapp.entities.Banque;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.exceptions.BanqueExistanteException;

public interface IBanqueService {

	public Banque save(Banque entity) throws BanqueExistanteException;

	public Banque update(Banque entity) throws BanqueExistanteException;

	public Banque getOne(Long id) throws BanqueExistanteException;
	
	public List<Banque> getAll();

	public Banque remove(Long id);
	
	public Banque AddCompteToBanque(Compte c, Long idBanque) throws BanqueExistanteException;
	
	public Banque AddClientToBanque(Client c, Long idBanque);
	
	public Banque AddEmployeToBanque(Employe e, Long idBanque);

	
}
