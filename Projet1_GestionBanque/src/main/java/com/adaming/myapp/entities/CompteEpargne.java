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

	public CompteEpargne(Long id, Date dateCreation, Double solde, List<Operation> operations, Client client,
			Employe employe) {
		super(id, dateCreation, solde, operations, client, employe);
		// TODO Auto-generated constructor stub
	}
	public CompteEpargne(Date dateCreation, Double solde, Client client) {
		super(dateCreation, solde, client);
		// TODO Auto-generated constructor stub
	}
	public CompteEpargne(Long id, Date dateCreation, Double solde, List<Operation> operations, Client client,
			Employe employe, Double tInteret) {
		super(id, dateCreation, solde, operations, client, employe);
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

}
