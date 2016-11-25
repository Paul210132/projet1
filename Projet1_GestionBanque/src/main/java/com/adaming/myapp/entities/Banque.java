package com.adaming.myapp.entities;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
public class Banque implements Serializable{

	/*ATTRIBUTES*/
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String adresse;
	private int cP;
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="EMPLOYES_BQ")
	private List<Employe> employes;
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="CLIENTS_BQ")
	private List<Client> clients;
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="COMPTES_BQ")
	private List<Compte> comptes;

	/*CONSTRUCTORS*/
	
	public Banque() {
		// TODO Auto-generated constructor stub
	}
	
	public Banque(String nom, String adresse, int cP) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.cP = cP;
	}

		
	/*GETTERS-SETTERS*/	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getcP() {
		return cP;
	}
	public void setcP(int cP) {
		this.cP = cP;
	}
	public List<Employe> getEmployes() {
		return employes;
	}
	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	public List<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
}
