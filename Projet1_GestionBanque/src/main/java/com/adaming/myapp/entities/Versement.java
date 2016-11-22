package com.adaming.myapp.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("VER")
public class Versement extends Operation{

	public Versement(Long id, Date date, Double montant, Employe employe, List<Compte> comptes) {
		super(id, date, montant, employe, comptes);
		// TODO Auto-generated constructor stub
	}

	public Versement(Date date, Double montant) {
		super(date, montant);
		// TODO Auto-generated constructor stub
	}

}
