package com.adaming.myapp.service.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.myapp.dao.ICompteDao;
import com.adaming.myapp.entities.*;
import com.adaming.myapp.exceptions.*;
import com.adaming.myapp.service.ICompteService;
import com.adaming.myapp.service.IEmployeService;
import com.adaming.myapp.service.IOperationService;

public class OperationServiceTestU {

	private final Logger LOGGER = Logger.getLogger("OperationServiceTestU ");
	
	private static ClassPathXmlApplicationContext context;
	
	private static IOperationService service;
	private static ICompteService serviceCompte;
	private static IEmployeService serviceEmploye;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context= new ClassPathXmlApplicationContext("app.xml");
		service = (IOperationService) context.getBean("OperationServiceImpl");
		serviceCompte = (ICompteService) context.getBean("CompteServiceImpl");
		serviceEmploye = (IEmployeService) context.getBean("EmployeServiceImpl");
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	  context.close();
	}
	
	@Test
	public void testSaveOperation() {
		Operation o = new Operation(new Date(), 10.);
		service.save(o);
		assertNotNull(o.getId());
		LOGGER.info("<-------AddOp OK---------> ");
		}
		
	@Test
	public void testUpdateOperation() {
		
		try {
			Operation o1 = new Operation(new Date(), 11.);
			service.save(o1);
			o1.setMontant(15.);
			service.update(o1);
			assertTrue(o1.getMontant()==15.);
			LOGGER.info("<-------UpdateOp OK---------> ");
		} catch (OperationExistanteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	public void testgetOneOperation() {
	
		try {
			Operation o2 = new Operation(new Date(), 10.);
			service.save(o2);
			service.getOne(o2.getId());
			assertNotNull(o2.getId());
			LOGGER.info("<-------GetOneOp OK---------> ");
		} catch (OperationExistanteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
	@Test
	public void testgetAllOperation() {
		
			Operation o2 = new Operation(new Date(), 10.);
			service.save(o2);
			List<Operation> operations = service.getAll();
			assertTrue(operations.size()>0);
			LOGGER.info("<-------GetAllOp OK---------> ");

		}
		
	@Test
	public void testDeleteOperation() {
			
			try {
				Operation o2 = new Operation(new Date(), 10.);
				service.save(o2);
				List<Operation> operations = service.getAll();
				service.remove(o2.getId());
				List<Operation> operations2 = service.getAll();
				assertTrue(operations.size()-1==operations2.size());
				LOGGER.info("<-------DeleteOp OK---------> ");
			} catch (OperationExistanteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	@Test
	public void testVersement() {
				Operation o = new Versement(new Date(), 100.);
				LOGGER.info("<--------------Instanciation Versement-------------->");
				Employe e = new Employe("Robert");
				LOGGER.info("Employe = new");
				serviceEmploye.save(e);
				LOGGER.info("employe saved to db");
				Compte cCred = new CompteCourant(new Date(), 20.);
				LOGGER.info("compte = new compte");
				serviceCompte.save(cCred);
				LOGGER.info("compte saved to db");
				LOGGER.info("<-------Elements instancies id employé "+e.getId()+" id compte "+cCred.getId()+"---------> ");
				service.save(o, e.getId(), cCred.getId());
				LOGGER.info("<-------Compte cred Ajouté---------> ");
				service.versement(cCred.getId(), e.getId(), o.getMontant());
				assertTrue((service.getCompte(cCred.getId())).getSolde()==120.);
				LOGGER.info("<-------Solde OK---------> ");
	}

	@Test
	public void testRetrait() {
				
				try {
					Operation o = new Retrait(new Date(), 100.);
					LOGGER.info("<--------------Instanciation Retrait-------------->");
					Employe e = new Employe("Robert");
					LOGGER.info("employe = new Employe");
					serviceEmploye.save(e);
					LOGGER.info("employe saved to db");
					Compte cDeb = new CompteEpargne(new Date(), 120.);
					//cDeb.setCalcul(-1000.);
					LOGGER.info("compte = new Compte");
					serviceCompte.save(cDeb);
					LOGGER.info("compte saved to db");
					LOGGER.info("<-------Elements instanciés id employé "+e.getId()+" id compte "+cDeb.getId()+"---------> ");
					service.save(o, e.getId(), cDeb.getId());
					LOGGER.info("<-------Compte deb Ajouté---------> ");
					service.retrait(cDeb.getId(), e.getId(), o.getMontant());
					LOGGER.info("Nouveau Solde"+service.getCompte(cDeb.getId()).getSolde()+"€ | 20.0€");
					assertTrue(service.getCompte(cDeb.getId()).getSolde()==20.);
					LOGGER.info("<-------Solde OK---------> ");
				} catch (SoldeInsuffisantException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	}
	
	@Test
	public void testVirement() {
				
				try {
					Operation o = new Virement(new Date(), 100.);
					LOGGER.info("<--------------Instanciation Virement-------------->");
					Employe e = new Employe("Michel");
					LOGGER.info("employe = new Employe");
					serviceEmploye.save(e);
					LOGGER.info("employe saved to db");
					Compte cDeb = new CompteCourant(new Date(), 120.);
					Compte cCred = new CompteEpargne(new Date(), 120.);
					cDeb.setCalcul(-200.);
					LOGGER.info("comptes cDeb & cCred = new Compte");
					serviceCompte.save(cDeb);
					serviceCompte.save(cCred);
					LOGGER.info("comptes saved to db");
					LOGGER.info("<-------Elements instanciés id employé "+e.getId()+" id compteD "+cDeb.getId()+"--id compteC "+cCred.getId()+"--------> ");
					service.save(o, e.getId(), cDeb.getId());
					LOGGER.info("<-------Compte deb n°"+cDeb.getId()+" Ajouté---------> ");
					LOGGER.info("Compte crédité n°"+cCred.getId()+"");
					service.save(o, e.getId(), cCred.getId());
					LOGGER.info("<-------Compte cred  Ajouté---------> ");
					service.virement(cDeb.getId(), cCred.getId(), e.getId(), o.getMontant());
					LOGGER.info("Nouveau Solde "+service.getCompte(cDeb.getId()).getSolde()+" €");
					assertTrue(service.getCompte(cDeb.getId()).getSolde()==20.);
					LOGGER.info("<-------Solde OK---------> ");
				}catch (SoldeInsuffisantException e1){
					e1.printStackTrace();
				}
	}
}

	

