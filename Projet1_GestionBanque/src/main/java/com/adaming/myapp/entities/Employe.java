package com.adaming.myapp.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
public class Employe implements Serializable{

	
	/*ATTRIBUTES*/
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	@OneToMany(mappedBy="employe")
	private List<Compte> comptes;
	
	/*CONSTRUCTORS*/
	
	public Employe() {
		// TODO Auto-generated constructor stub
	}
	
	public Employe(Long id, String nom, List<Compte> comptes) {
		super();
		this.id = id;
		this.nom = nom;
		this.comptes = comptes;
	}
	public Employe(String nom) {
		super();
		this.nom = nom;
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
	public List<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	
}
