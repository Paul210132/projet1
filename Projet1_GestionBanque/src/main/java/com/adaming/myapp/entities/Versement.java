package com.adaming.myapp.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("VER")
public class Versement extends Operation{



	public Versement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Versement(Long id, Date date, Double montant) {
		super(id, date, montant);
		// TODO Auto-generated constructor stub
	}

	public Versement(Date date, Double montant) {
		super(date, montant);
		// TODO Auto-generated constructor stub
	}

}
