package com.adaming.myapp.service.test;

import static org.junit.Assert.*;

import java.util.List;

import org.hamcrest.core.IsEqual;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.entities.Groupe;
import com.adaming.myapp.exceptions.GroupeExistantException;
import com.adaming.myapp.service.IEmployeService;
import com.adaming.myapp.service.IGroupeService;

public class GroupeServiceTestU {
	
    private static ClassPathXmlApplicationContext context;
	
	private static IGroupeService service;
	private static IEmployeService service2;
	
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	  context= new ClassPathXmlApplicationContext("app.xml");
	  service = (IGroupeService) context.getBean("GroupeServiceImpl");
	  service2 = (IEmployeService) context.getBean("EmployeServiceImpl");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	  context.close();
	}

	/*@Test
	public void testSaveGroupe() {
		Groupe c = new Groupe("nom");
		service.save(c);
		assertNotNull(c.getId());	
	}


	@Test
	public void testDeleteGroupe() throws GroupeExistantException {
		Groupe c = new Groupe("nom");
		service.save(c);
		List<Groupe> Groupes = service.getAll();
		service.remove(2L);
		List<Groupe> Groupes2 = service.getAll();
		assertTrue(Groupes.size()-1==Groupes2.size());
	}

	@Test
	public void testUpdateGroupe() throws GroupeExistantException{
		Groupe c = new Groupe("nom");
		service.save(c);
		Groupe c1 = service.getOne(2L);
		c1.setNom("nomMod");
		service.update(c1);
		Groupe c2 = service.getOne(2L);
		Assert.assertThat("nomMod", IsEqual.equalTo(c2.getNom()));
	}*/

	@Test
	public void testaddEmployeToGroupe() throws GroupeExistantException {
		Groupe g1 = new Groupe("nom");
		Employe e1 = new Employe("nom");
		service.save(g1);
		service2.save(e1);
		service.addEmployeToGroupe(1L,1L);
		System.out.println("blabla");
		Groupe groupeTest = service.getOne(1L);
		Employe employeTest = groupeTest.getEmployes().get(0);
		assertTrue(employeTest.getId()==1);
		
		
	}

	

}