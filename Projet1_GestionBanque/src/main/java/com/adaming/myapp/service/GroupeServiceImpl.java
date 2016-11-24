package com.adaming.myapp.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.dao.IGroupeDao;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.entities.Groupe;
import com.adaming.myapp.exceptions.GroupeExistantException;

@Transactional
public class GroupeServiceImpl implements IGroupeService{

	private IGroupeDao gdao;
	
	

	private final Logger LOGGER  = Logger.getLogger("GroupeServiceImpl");
	
	
	public void setGdao(IGroupeDao gdao) {
		this.gdao = gdao;
		LOGGER.info("<---------- dao injected------->");
	}

	@Override
	public Groupe save(Groupe entity) {
		LOGGER.info("Le groupe a bien été créé");
		return gdao.save(entity);
	}

	@Override
	public Groupe update(Groupe entity) throws GroupeExistantException{
		List<Groupe> groupes = getAll();
		int i = 0;
		for (Groupe g1 : groupes){
			if(g1.getId()==entity.getId()){
				i++;
			}
		}
		if (i==0){
			throw new GroupeExistantException("Le groupe n'existe pas");}
		else{
			LOGGER.info("Le groupe a bien été sauvegardé");
			return gdao.update(entity);
		}
	}

	@Override
	public Groupe getOne(Long id) throws GroupeExistantException {
		List<Groupe> groupes = getAll();
		int i = 0;
		for (Groupe g1 : groupes){
			if(g1.getId()==id){
				i++;
			}
		}
		if (i==0){
			throw new GroupeExistantException("Le groupe n'existe pas");}
		else{
			return gdao.getOne(id);
		}
	}

	@Override
	public List<Groupe> getAll() {
		return gdao.getAll();
	}

	@Override
	public Groupe remove(Long id) throws GroupeExistantException {
		List<Groupe> groupes = getAll();
		int i = 0;
		for (Groupe g1 : groupes){
			if(g1.getId()==id){
				i++;
			}
		}
		if (i==0){
			throw new GroupeExistantException("Le groupe n'existe pas");}
		else{
			LOGGER.info("Le groupe a bien été supprimé");
			return gdao.remove(id);
		}
	}

	@Override
	public Groupe addEmployeToGroupe(Long idGroupe, Long idEmploye) {
		LOGGER.info("L'employé a bien été ajouté au groupe");
		return gdao.addEmployeToGroupe(idGroupe, idEmploye);
	}

	


	
	

}
