package com.adaming.myapp.service.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
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
import com.adaming.myapp.service.IBanqueService;
import com.adaming.myapp.service.IClientService;
import com.adaming.myapp.service.ICompteService;
import com.adaming.myapp.service.IEmployeService;


public class BanqueServiceTestU {
	
    private final Logger LOGGER = Logger.getLogger("ClientServiceTestU ");
	
    private static ClassPathXmlApplicationContext context;
	
	private static IBanqueService  service;
	private static ICompteService  serviceCpte;
	private static IClientService  serviceCli;
	private static IEmployeService serviceEmpl;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	  context= new ClassPathXmlApplicationContext("app.xml");
	  service = (IBanqueService) context.getBean("BanqueServiceImpl");
	  serviceCpte = (ICompteService) context.getBean("CompteServiceImpl");
	  serviceCli = (IClientService) context.getBean("ClientServiceImpl");
	  serviceEmpl = (IEmployeService) context.getBean("EmployeServiceImpl");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	  context.close();
	}
	
	@Test
	@Ignore
	public void testAddBanque() throws BanqueExistanteException {
		Banque b1 = new Banque("LCL", "adresse3", 75003);
		try{
			service.save(b1);
			assertNotNull(b1.getId());
		} catch (BanqueExistanteException e) {
			LOGGER.warn(e.getMessage());
		}
	}

	@Test
	@Ignore
	public void testDeleteBanque() throws BanqueExistanteException {
		List<Banque> banques = service.getAll();
		service.remove(3L);
		List<Banque> banques2 = service.getAll();
		assertTrue(banques.size()-1==banques2.size());
	}

	@Test
	@Ignore
	public void testUpdateBanque() throws BanqueExistanteException {
		Banque b1 = service.getOne(1L);
		b1.setNom("nom modif");
		service.update(b1);
		Banque b2 = service.getOne(1L);
		Assert.assertThat("nom modif", IsEqual.equalTo(b2.getNom()));

	}

	@Test
	@Ignore
	public void testGetBanque() throws BanqueExistanteException {
		Banque b = service.getOne(1L);
		assertTrue(b != null);
	}

	@Test
	@Ignore
	public void testGetBanques() {
		List<Banque> banques = service.getAll();
		assertTrue(banques.size()>0);
	}

	@Test
	@Ignore
	public void testAddCompteToBanque() throws BanqueExistanteException {
		Double solde = 11.20;
		Compte c1 = new CompteCourant(new Date(),solde);
		serviceCpte.save(c1);
		service.AddCompteToBanque(c1, 1L);
		System.out.println("bla3");
		Banque b = service.getOne(1L);
		List<Compte> ListeComptes = b.getComptes();
		int i =0;
		for(Compte cp: ListeComptes){
			if(cp.getId()==c1.getId()){
			      i++;
			}
		}
		assertTrue(i>0);     
	}
	
	@Test
	@Ignore
	public void testAddClientToBanque() throws BanqueExistanteException, ClientExistantException {
		Client c1 = new Client("nom1","prenom1",new Date(),"adresse1");
		serviceCli.save(c1);
		service.AddClientToBanque(c1, 1L);	
		
		Banque b = service.getOne(1L);
		List<Client> ListeClients = b.getClients();
		int i =0;
		for(Client c: ListeClients){
			if(c.getId()==c1.getId()){
			      i++;
			}
		}
		assertTrue(i>0); 
	}
	
	@Test
	public void testAddEmployeToBanque() throws BanqueExistanteException, ClientExistantException {
		Employe e1 = new Employe("Martin");
		serviceEmpl.save(e1);
		service.AddEmployeToBanque(e1, 1L);	
		
		Banque b = service.getOne(1L);
		List<Employe> ListeEmployes = b.getEmployes();
		int i =0;
		for(Employe e: ListeEmployes){
			if(e.getId()==e1.getId()){
			      i++;
			}
		}
		assertTrue(i>0); 
	}
}
