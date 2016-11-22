package com.adaming.myapp.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("VIR")
public class Virement extends Operation{

	public Virement(Date date, Double montant) {
		super(date, montant);
		// TODO Auto-generated constructor stub
	}

	public Virement(Long id, Date date, Double montant, Employe employe, List<Compte> comptes) {
		super(id, date, montant, employe, comptes);
		// TODO Auto-generated constructor stub
	}

}
