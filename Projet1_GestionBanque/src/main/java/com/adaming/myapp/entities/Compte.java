package com.adaming.myapp.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE",discriminatorType=DiscriminatorType.STRING)
public abstract class Compte implements Serializable{

	
	/*ATTRIBUTES*/
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Date dateCreation;
	private Double solde;
	@ManyToMany(mappedBy="comptes")
	private List<Operation> operations;
	@ManyToOne
	@JoinTable(name="COMPTES_CL")
	private Client client;
	@ManyToOne
	@JoinTable(name="COMPTES_EMPL")
	private Employe employe;
	/*CONSTRUCTORS*/
	
	public Compte() {
		// TODO Auto-generated constructor stub
	}
	
	public Compte(Long id, Date dateCreation, Double solde, List<Operation> operations, Client client,
			Employe employe) {
		super();
		this.id = id;
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.operations = operations;
		this.client = client;
		this.employe = employe;
	}
	public Compte(Date dateCreation, Double solde, Client client) {
		super();
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.client = client;
	}
	
	/*GETTERS-SETTERS*/
	
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
	
	public abstract Double getCalcul();
	
	
}
