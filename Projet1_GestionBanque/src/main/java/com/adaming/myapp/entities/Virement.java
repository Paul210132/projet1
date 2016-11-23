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

	public Virement(Long id, Date date, Double montant) {
		super(id, date, montant);
		// TODO Auto-generated constructor stub
	}


}
