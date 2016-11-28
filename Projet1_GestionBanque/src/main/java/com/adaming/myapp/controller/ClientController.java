package com.adaming.myapp.controller;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.entities.Operation;
import com.adaming.myapp.exceptions.ClientExistantException;
import com.adaming.myapp.exceptions.CompteExistantException;
import com.adaming.myapp.model.ClientModel;
import com.adaming.myapp.model.CompteModel;
//import com.adaming.myapp.model.ClientModel;
import com.adaming.myapp.service.IClientService;
import com.adaming.myapp.service.ICompteService;

@Controller
public class ClientController {

	private final Logger LOGGER = Logger.getLogger("ClientController");
    @Inject
	private IClientService service;
    @Inject
	private ICompteService serviceCpt;
	
	@RequestMapping(value="/getClient",method=RequestMethod.GET)
	public String init(Model model){
		List<Client> clients = service.getAll();
		ClientModel cm = new ClientModel();
		cm.setClients(clients);
		model.addAttribute("clModel",cm);
		return "client";
	}

	@RequestMapping(value="/getClient/addClient",method=RequestMethod.GET)
	public String add(Model model,
			        @ModelAttribute("clModel")  @Valid ClientModel cm,BindingResult result
			          ){
		    if(result.hasErrors()){
		    	List<Client> clients = service.getAll();
				cm.setClients(clients);
				model.addAttribute("clModel",cm);
		    	return "client";
		    }
		
		try {
			Client c = new Client(cm.getNom(), cm.getPrenom(), new Date(),cm.getAdresse());
			service.save(c);
			List<Client> clients = service.getAll();
			cm.setClients(clients);
			model.addAttribute("clModel",cm);
			
			return "redirect:/";
		} catch (ClientExistantException e) {
			cm.setExceptionClient(e.getMessage());
			model.addAttribute("clModel",cm);
			LOGGER.info("exception"+cm.getExceptionClient());
			List<Client> clients = service.getAll();
			cm.setClients(clients);
			return "client";
		}
		
	}
	@RequestMapping(value="/getClient/get/{id}",method=RequestMethod.GET)
	public String getClient(Model model,@PathVariable Long id) throws ClientExistantException{
		LOGGER.info("id : "+id);
		ClientModel clientmodel = new ClientModel();
		clientmodel.setId(id);
		Client c = service.getOne(id);
		clientmodel.setClient(c);
		model.addAttribute("cm",clientmodel);
		LOGGER.info("Client : "+clientmodel.getClient());
		return "getClient";
	}
	@RequestMapping(value="/getClient/update",method=RequestMethod.GET)
	public String update(Model model,ClientModel cm,Client c) throws ClientExistantException{
		service.update(c);
		List<Client> clients = service.getAll();
		cm.setClients(clients);
		model.addAttribute("clModel",cm);
		return "client";
	}
	@RequestMapping(value="/getClient/getByMc")
	public String getByMc(Model model,ClientModel CliMod){
		model.addAttribute("clModel",new ClientModel());
		List<Client> clientsMc = service.getClient(CliMod.getMc());
		CliMod.setClients(clientsMc);
		model.addAttribute("clModel2",CliMod);
		return "client";
	}

	@RequestMapping(value="/getClient/getComptes/{id}")
	public String getComptes(Model model,ClientModel CliMod, @PathVariable Long id){
		CliMod = new ClientModel();
		model.addAttribute("clModel",CliMod);
		Client cli;
		try {
			cli = service.getOne(id);
			List<Compte> comptes = cli.getComptes();
			CliMod.setComptes(comptes);
			LOGGER.info("Compte d'un client : "+comptes);
			model.addAttribute("clModel3",CliMod);
		} catch (ClientExistantException e) {
			CliMod.setExceptionClient(e.getMessage());
		}

		return "client";
	}
	
	@RequestMapping(value="/getClient/getOpe/{id}")
	public String getOpe(Model model,CompteModel CptMod, @PathVariable Long id){
		CptMod = new CompteModel();
		model.addAttribute("cptModel",CptMod);
		Compte cpt;
		try {
			cpt = serviceCpt.getOne(id);
			List<Operation> operations = cpt.getOperations();
			CptMod.setOperations(operations);
			LOGGER.info("Opération du compte : "+operations);
			model.addAttribute("clModel4",CptMod);
		} catch (CompteExistantException e) {
			CptMod.setExceptionCompte(e.getMessage());
		}

		return "client";
	}
	
}
