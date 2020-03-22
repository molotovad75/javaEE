package com.sdzee.beans;

public class Auteur {
	private static String nom;
	private static String prenom;
	
	public static String getNom() {
		return nom;
	}
	public static void setNom(String nom) {
		Auteur.nom = nom;
	}
	public static String getPrenom() {
		return prenom;
	}
	public static void setPrenom(String prenom) {
		Auteur.prenom = prenom;
	}
	
}
