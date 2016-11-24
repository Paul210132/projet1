package com.adaming.myapp.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("RET")
public class Retrait extends Operation{

	public Retrait() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Retrait(Date date, Double montant) {
		super(date, montant);
		// TODO Auto-generated constructor stub
	}

	public Retrait(Long id, Date date, Double montant) {
		super(id, date, montant);
		// TODO Auto-generated constructor stub
	}

	

}
