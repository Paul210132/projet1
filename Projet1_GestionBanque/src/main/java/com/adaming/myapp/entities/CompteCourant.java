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
	
	public CompteCourant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CompteCourant(Date dateCreation, Double solde) {
		super(dateCreation, solde);
		// TODO Auto-generated constructor stub
	}
	public CompteCourant(Double decouvert) {
		super();
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
	@Override
	public void setCalcul(Double decouvert) {
		// TODO Auto-generated method stub
		this.decouvert = decouvert;
	}

}

	