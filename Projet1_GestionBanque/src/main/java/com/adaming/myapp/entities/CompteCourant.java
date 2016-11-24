package com.adaming.myapp.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte{

	/*ATTRIBUTES*/
	
	private Double decouvert;
	
	/*CONSTRUCTORS*/
	
	public CompteCourant(Long id, Date dateCreation, Double solde, List<Operation> operations, Client client,
			Employe employe) {
		super(id, dateCreation, solde, operations, client, employe);
		// TODO Auto-generated constructor stub
	}
	public CompteCourant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CompteCourant(Date dateCreation, Double solde, Client client) {
		super(dateCreation, solde, client);
		// TODO Auto-generated constructor stub
	}
	public CompteCourant(Long id, Date dateCreation, Double solde, List<Operation> operations, Client client,
			Employe employe, Double decouvert) {
		super(id, dateCreation, solde, operations, client, employe);
		this.decouvert = decouvert;
	}

	/*GETTERS&SETTERS*/
	
	public Double getDecouvert() {
		return decouvert;
	}
	public void setDecouvert(Double decouvert) {
		this.decouvert = decouvert;
	}
	@Override
	public Double getCalcul() {
		// TODO Auto-generated method stub
		return decouvert;
	}

}

	