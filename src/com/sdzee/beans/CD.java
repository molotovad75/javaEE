package com.sdzee.beans;

public class CD extends Document {

	private Auteur auteur_cd;

	public Auteur getAuteur_CD() {
		this.setAuteur(auteur_cd);
		return this.getAuteur();
	}
}
