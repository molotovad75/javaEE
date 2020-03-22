package com.sdzee.beans;

public class Livre extends Document {

	private Auteur auteur_livre;

	public Auteur getAuteur_livre() {
		this.setAuteur(auteur_livre);
		return this.getAuteur();
	}
	
	public void setAuteurLivre(String nomAuteur,String prenomAuteur) {
		Auteur.setNom(nomAuteur);
		Auteur.setPrenom(prenomAuteur);
		this.setAuteur(auteur_livre);
	}
}
