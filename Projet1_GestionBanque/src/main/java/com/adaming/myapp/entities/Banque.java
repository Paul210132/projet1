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
	private int CP;
	@OneToMany
	@JoinColumn(name="EMPLOYES_BQ")
	private List<Employe> employes;
	@OneToMany
	@JoinColumn(name="CLIENTS_BQ")
	private List<Client> clients;
	@OneToMany
	@JoinColumn(name="COMPTES_BQ")
	private List<Compte> comptes;

	/*CONSTRUCTORS*/
	
	public Banque(Long id, String nom, String adresse, int cP, List<Employe> employes, List<Client> clients,
			List<Compte> comptes) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		CP = cP;
		this.employes = employes;
		this.clients = clients;
		this.comptes = comptes;
	}
	public Banque(String nom, List<Employe> employes, List<Compte> comptes) {
		super();
		this.nom = nom;
		this.employes = employes;
		this.comptes = comptes;
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
	public int getCP() {
		return CP;
	}
	public void setCP(int cP) {
		CP = cP;
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
