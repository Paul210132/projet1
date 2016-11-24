package com.adaming.myapp.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
public class Groupe implements Serializable{

	/*ATTRIBUTES*/
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="EMPLOYES_GRP")
	private List<Employe> employes = new ArrayList<Employe>();
	
	/*CONSTRUCTORS*/
	
	public Groupe() {
		// TODO Auto-generated constructor stub
	}
	
	public Groupe(Long id, String nom, List<Employe> employes) {
		super();
		this.id = id;
		this.nom = nom;
		this.employes = employes;
	}
	public Groupe(String nom) {
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
	public List<Employe> getEmployes() {
		return employes;
	}
	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}
	
	
}
