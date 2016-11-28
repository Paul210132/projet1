package com.adaming.myapp.model;

import java.util.Date;
import java.util.List;

import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.entities.Operation;

public class CompteModel {

	
	private Long id;
	private Date dateCreation;	
	private Double solde;
	private String exceptionCompte; 

	private List<Operation> operations;
	private Client client;
	private Employe employe;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Double getSolde() {
		return solde;
	}
	public void setSolde(Double solde) {
		this.solde = solde;
	}
	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public String getExceptionCompte() {
		return exceptionCompte;
	}
	public void setExceptionCompte(String exceptionCompte) {
		this.exceptionCompte = exceptionCompte;
	}
	
}
