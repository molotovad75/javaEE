package com.sdzee.beans;

public class Utilisateur {
	private String login;
	private String mdp;
	private String nom;
	private String email;
	private int biblio;
	private static boolean estbiblio;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getlogin() {
		return login;
	}
	public void setlogin(String login) {
		this.login = login;
	}
	public String getmdp() {
		return mdp;
	}
	public void setmdp(String mdp) {
		this.mdp = mdp;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getBiblio() {
		return biblio;
	}
	public void setBiblio(int biblio) {
		this.biblio = biblio;
	}
	public static boolean isEstbiblio() {
		return estbiblio;
	}
	
	public static void setEstbiblio(boolean estbiblio2) {
		estbiblio = estbiblio2;
	}
	
	
	
}
