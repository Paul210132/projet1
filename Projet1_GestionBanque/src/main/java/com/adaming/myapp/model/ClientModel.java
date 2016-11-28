package com.adaming.myapp.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Compte;

public class ClientModel {
	private String mc;
	private String exceptionClient;
	private Long id;
	private Client client= new Client();
	
	@NotEmpty(message="obligatoire")
	@Size(max=10,min=5)
    private String nom;
	
	@NotEmpty
    private String prenom;
	
	@NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateNaissance;
	private String adresse;
	
	private List<Client> clients;
	private List<Compte> comptes;

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	public String getMc() {
		return mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

	public String getExceptionClient() {
		return exceptionClient;
	}

	public void setExceptionClient(String exceptionClient) {
		this.exceptionClient = exceptionClient;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

}
