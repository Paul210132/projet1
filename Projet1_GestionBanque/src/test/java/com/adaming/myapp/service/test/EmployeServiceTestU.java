package com.adaming.myapp.service.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.hamcrest.core.IsEqual;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.exceptions.EmployeExistantException;
import com.adaming.myapp.service.IEmployeService;

public class EmployeServiceTestU {
	
	private static ClassPathXmlApplicationContext context;
	
	private static IEmployeService service;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	  context= new ClassPathXmlApplicationContext("app.xml");
	  service = (IEmployeService) context.getBean("GroupeServiceImpl");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	  context.close();
	}
	
	@Test
	public void testSaveEmploye() {
		Employe e = new Employe("nom");
		service.save(e);
		assertNotNull(e.getId());	
	}


	@Test
	public void testDeleteEmploye() throws EmployeExistantException {
		Employe c = new Employe("nom");
		service.save(c);
		List<Employe> Employes = service.getAll();
		service.remove(2L);
		List<Employe> Employes2 = service.getAll();
		assertTrue(Employes.size()-1==Employes2.size());
	}

	@Test
	public void testUpdateEmploye() throws EmployeExistantException{
		Employe c = new Employe("nom");
		service.save(c);
		Employe c1 = service.getOne(2L);
		c1.setNom("JeanLouis");
		service.update(c1);
		Employe c2 = service.getOne(2L);
		assertTrue(c2.getNom().equals("JeanLouis"));
	}
}
