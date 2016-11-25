package com.adaming.myapp.service.test;

import static org.junit.Assert.*;

import java.util.Date;



import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.hamcrest.core.IsEqual;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.entities.CompteCourant;
import com.adaming.myapp.exceptions.CompteExistantException;
import com.adaming.myapp.service.IClientService;
import com.adaming.myapp.service.ICompteService;

public class CopyOfCompteServiceTestU {
    private final Logger LOGGER = Logger.getLogger("CompteServiceTestU ");
	
    private static ClassPathXmlApplicationContext context;
	
	private static ICompteService service;
	

	
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	  context= new ClassPathXmlApplicationContext("app.xml");
	  service = (ICompteService) context.getBean("CompteServiceImpl");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	  context.close();
	}

	@Test
	public void testSaveCompte() {
		Compte c = new CompteCourant(new Date(),15D);
		service.save(c);
		assertNotNull(c.getId());	
	}


	@Test
	public void testDeleteCompte() throws CompteExistantException {
		Compte c = new CompteCourant(new Date(),15D);
		service.save(c);
		List<Compte> comptes = service.getAll();
		service.remove(1L);
		List<Compte> comptes2 = service.getAll();
		assertTrue(comptes.size()-1==comptes2.size());
	}

	@Test
	public void testUpdateCompte() throws CompteExistantException{
		Compte c = new CompteCourant(new Date(),15D);
		service.save(c);
		Compte c1 = service.getOne(1L);
		c1.setSolde(135D);
		service.update(c1);
		Compte c2 = service.getOne(1L);
		Assert.assertThat(135D, IsEqual.equalTo(c2.getSolde()));
	}



}
