package com.sdzee.beans;

public class DVD extends Document {

	private Auteur auteur_dvd;
	
	
	
	public Auteur getAuteur_dvd() {
		this.setAuteur(auteur_dvd);
		return this.getAuteur();
	}
}
