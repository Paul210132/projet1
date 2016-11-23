package com.adaming.myapp.service;

import java.util.List;

import com.adaming.myapp.entities.Client;
import com.adaming.myapp.exceptions.ClientExistantException;

public interface IClientService {

	public Client save(Client entity) throws ClientExistantException;

	public Client update(Client entity) throws ClientExistantException;
	
	public Client getOne(Long id) throws ClientExistantException;

	public List<Client> getAll();

	public Client remove(Long id) throws ClientExistantException;

	public List<Client> getClient(String mc);
	
}
