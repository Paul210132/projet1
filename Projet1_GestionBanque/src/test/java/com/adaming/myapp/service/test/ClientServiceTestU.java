package com.adaming.myapp.service.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hamcrest.core.IsEqual;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.myapp.entities.Banque;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.entities.CompteCourant;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.exceptions.BanqueExistanteException;
import com.adaming.myapp.exceptions.ClientExistantException;
import com.adaming.myapp.service.IClientService;
import com.adaming.myapp.service.ICompteService;

public class ClientServiceTestU {
	
    private final Logger LOGGER = Logger.getLogger("ClientServiceTestU ");
	
    private static ClassPathXmlApplicationContext context;
	
	private static IClientService service;
	private static ICompteService serviceCpte;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	  context= new ClassPathXmlApplicationContext("app.xml");
	  service = (IClientService) context.getBean("ClientServiceImpl");
	  serviceCpte = (ICompteService) context.getBean("CompteServiceImpl");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	  context.close();
	}
	
	@Test
	@Ignore
	public void testAddClient() throws ClientExistantException {
		Client c1 = new Client("nom1","prenom1",new Date(),"Adresse1");
		Client c2 = new Client("nom2","prenom2",new Date(),"Adresse2");
		//Client c1 = new Client(3L,"nom1","prenom1",new Date(),"adresse1",comptes);
		//Client c2 = new Client(2L,"nom2","prenom2",new Date(),"adresse2",comptes);
		try{
			service.save(c1);
			assertNotNull(c1.getId());
			service.save(c2);
			assertNotNull(c2.getId());
		} catch (ClientExistantException e) {
			LOGGER.warn(e.getMessage());
		}
	}
	
	@Test
	@Ignore
	public void testDeleteClient() throws ClientExistantException {
		List<Client> clients = service.getAll();
		service.remove(3L);
		List<Client> clients2 = service.getAll();
		assertTrue(clients.size()-1==clients2.size());
	}

	@Test
	@Ignore
	public void testUpdateClient() throws ClientExistantException {
		Client c1 = service.getOne(2L);
		c1.setNom("nom modif");
		service.update(c1);
		Client c2 = service.getOne(2L);
		Assert.assertThat("nom modif", IsEqual.equalTo(c2.getNom()));

	}
	
	@Test
	@Ignore
	public void testGetClient() throws ClientExistantException {
		Client c = service.getOne(2L);
		assertTrue(c != null);
	}

	@Test
	@Ignore
	public void testGetClients() {
		List<Client> clients = service.getAll();
		assertTrue(clients.size()>0);
	}

	@Test
	public void testGetClientByMc() {
		List<Client> clients = service.getClient("o");
		for(Client c:clients){
			if(c.getNom().equals("o")){
				assert(true);
			}
		}
	}
	
	@Test
	public void testAddCompteToClient() throws ClientExistantException {
		Compte cp1 = new CompteCourant(new Date(),13.45);
		serviceCpte.save(cp1);
		service.AddCompteToClient(cp1, 11L);
		Client cl = service.getOne(11L);
		List<Compte> ListeComptes = cl.getComptes();
		int i =0;
		for(Compte cp: ListeComptes){
			if(cp.getId()==cp1.getId()){
			      i++;
			}
		}
		assertTrue(i>0); 	
		System.out.println(i);
	}
}
