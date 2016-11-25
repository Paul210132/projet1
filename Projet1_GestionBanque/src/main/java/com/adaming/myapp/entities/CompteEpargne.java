package com.adaming.myapp.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte{
	
	/*ATTRIBUTES*/
	
	private Double tInteret;
	
	/*CONSTRUCTORS*/

	public CompteEpargne() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CompteEpargne(Date dateCreation, Double solde) {
		super(dateCreation, solde);
		// TODO Auto-generated constructor stub
	}
	public CompteEpargne(Double tInteret) {
		super();
		this.tInteret = tInteret;
	}
	
	/*GETTERS&SETTERS*/
	
	public Double gettInteret() {
		return tInteret;
	}

	public void settInteret(Double tInteret) {
		this.tInteret = tInteret;
	}
	@Override
	public Double getCalcul() {
		// TODO Auto-generated method stub
		return tInteret;
	}
	@Override
	public void setCalcul(Double tInteret) {
		this.tInteret = tInteret;
		
	}

}
