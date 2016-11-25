package com.adaming.myapp.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.dao.IClientDao;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.exceptions.ClientExistantException;
@Transactional
public class ClientServiceImpl implements IClientService{
	
	private IClientDao dao;
	
	
	public void setDao(IClientDao dao) {
		LOGGER.info("<-------- dao injected -------->");
		this.dao = dao;
	}

	private final Logger LOGGER  = Logger.getLogger("ClientServiceImpl");
	

	
	@Override
	public Client save(Client c) throws ClientExistantException {
		List<Client> clients = getAll();
		int i = 0;
        for (Client c1 : clients){
            if(c1.getId()==c.getId()){
                i++;
            }
        }
        if (i==0){
        	LOGGER.info("Le client "+c.getNom()+" a bien été enregistré.");
        	return dao.save(c);
        }else{
        	throw new ClientExistantException("Le client existe déjà."); 
        }
	}

	@Override
	public Client update(Client c) throws ClientExistantException {
		List<Client> clients = getAll();
		int i = 0;
        for (Client c1 : clients){
            if(c1.getId()==c.getId()){
                i++;
            }
        }
        if (i==0){
        	throw new ClientExistantException("Le client n'existe pas"); 
        }else{
        	LOGGER.info("Le client "+c.getNom()+" a bien été mis-à-jour");
        	return dao.update(c);
        }
	}

	@Override
	public Client getOne(Long id) throws ClientExistantException {
		List<Client> clients = getAll();
		int i = 0;
        for (Client c1 : clients){
            if(c1.getId()==id){
                i++;
            }
        }
        if (i==0){
            throw new ClientExistantException("Le client n'existe pas");
        }else{
            LOGGER.info("Le client ayant pour identidiant "+id+" est le suivant :");
            return dao.getOne(id);
        }
	}

	@Override
	public List<Client> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public Client remove(Long id) throws ClientExistantException {
		LOGGER.info("Le client "+getOne(id).getNom()+" a été supprimé");
		return dao.remove(id);
	}

	@Override
	public List<Client> getClient(String mc) {
		// TODO Auto-generated method stub
		return dao.getClient(mc);
	}

	@Override
	public Client AddCompteToClient(Compte c, Long idClient) {
		// TODO Auto-generated method stub
		return dao.AddCompteToClient(c, idClient);
	}
}
