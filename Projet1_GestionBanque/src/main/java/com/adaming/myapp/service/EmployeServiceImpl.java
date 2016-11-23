package com.adaming.myapp.service;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.dao.IEmployeDao;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.entities.Groupe;
import com.adaming.myapp.exceptions.EmployeExistantException;

@Transactional
public class EmployeServiceImpl implements IEmployeService{
	
	private IEmployeDao dao;
	private final Logger LOGGER  = Logger.getLogger("EmployeServiceImpl");
	List<Employe> employes = getAll();
	
	public void setDao(IEmployeDao dao) {
		LOGGER.info("<---------- dao injected------->");
		this.dao = dao;
	}
	
	@Override
	public Employe save(Employe entity) {
		LOGGER.info("<---------- Employe added------->");
		return dao.save(entity);
	}

	@Override
	public Employe update(Employe entity) throws EmployeExistantException {
		int i = 0;
        for (Employe c1 : employes){
            if(c1.getId()==entity.getId()){
                i++;
            }
        }
        if (i==0){
            throw new EmployeExistantException("L'employé n'existe pas");}
        else{
        	LOGGER.info("<---------- Employe read------->");
        	return dao.update(entity);
        }
	}

	@Override
	public Employe getOne(Long id) throws EmployeExistantException {
		int i = 0;
        for (Employe c1 : employes){
            if(c1.getId()==id){
                i++;
            }
        }
        if (i==0){
            throw new EmployeExistantException("L'employé n'existe pas");}
        else{
        	LOGGER.info("<---------- Employe read------->");
        	return dao.getOne(id);
        }
	}

	@Override
	public List<Employe> getAll() {
		LOGGER.info("<---------- Employe readAll------->");
		return dao.getAll();
	}

	@Override
	public Employe remove(Long id) throws EmployeExistantException {
		int i = 0;
        for (Employe c1 : employes){
            if(c1.getId()==id){
                i++;
            }
        }
        if (i==0){
            throw new EmployeExistantException("L'employé n'existe pas");}
        else{
        	LOGGER.info("<---------- Employe deleted------->");
        	return dao.getOne(id);
        }
	}

	@Override
	public List<Employe> getEmploye(Long idGroupe) throws EmployeExistantException {	
		Groupe groupe = dao.getGroupe(idGroupe);
        if(groupe.getEmployes().size() == 0)
        	{
        		throw new EmployeExistantException("Le groupe n'a aucun employé");
            }
		else{
        	LOGGER.info("<---------- Group Employe read------->");
        	return dao.getEmploye(idGroupe);
        }
	}

}
