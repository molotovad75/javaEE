package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import empruntable.Document;
import fonctionnalités.ServeurEmprunt;
import fonctionnalités.ServeurRetour;
import fonctionnalités.ServeurRéservation;
import instanciable.Abonne;
import instanciable.DVD;
import instanciable.Livre;

public class AppliBibliothèque {

	private static final int PORT_RESERVATION = 2500;
	private static final int PORT_EMPRUNT = 2600;
	private static final int PORT_RETOUR = 2700;

	public static int cpt_abo = 1;
	public static List<Abonne> abonnés;
	public static int cpt_doc = 1;
	public static List<Document> documents;

	public static void main(String[] args) {

		// remplissage des pseudo-bdd
		abonnés = new ArrayList<Abonne>();
		abonnés.add(new Abonne("Leroux", "Clara", 15));
		abonnés.add(new Abonne("Richeme", "Tristan", 16));
		abonnés.add(new Abonne("Servant", "Logan", 4));
		abonnés.add(new Abonne("Brette", "Jean-François", 23));

		documents = new ArrayList<Document>();
		documents.add(new Livre("Harry Potter", "Rowling"));
		documents.add(new Livre("50 nuances de Grey", "James"));
		documents.add(new Livre("Les misérables", "Hugo"));
		documents.add(new Livre("Othello", "Shakespeare"));
		documents.add(new DVD("Interstellar", "Nolan"));
		documents.add(new DVD("Inception", "Nolan"));
		documents.add(new DVD("Django Unchained", "Tarantino", 16));
		documents.add(new DVD("Joker", "Phillips", 12));

//		for (Document d : documents) {
//			System.out.println(d);
//		}

		// lancement des serveurs
		try {
			new Thread(new ServeurRéservation(PORT_RESERVATION), "ServeurRéservationThread").start();
			System.out.println("Serveur de réseravtion correctement lancé sur le port " + PORT_RESERVATION);
		} catch (IOException ioe2) {
			System.err.println("Le serveur de réservation n'a pas pu être créé :");
			System.err.println(ioe2.getMessage());
			return;
		}
		
		try {
			new Thread(new ServeurEmprunt(PORT_EMPRUNT), "ServeurEmpruntThread").start();
			System.out.println("Serveur d'emprunt correctement lancé sur le port " + PORT_EMPRUNT);
		} catch (IOException ioe1) {
			System.err.println("Le serveur d'emprunt n'a pas pu être créé :");
			System.err.println(ioe1.getMessage());
			return;
		}

		try {
			new Thread(new ServeurRetour(PORT_RETOUR), "ServeurRetourThread").start();
			System.out.println("Serveur de retour correctement lancé sur le port " + PORT_RETOUR);
		} catch (IOException ioe3) {
			System.err.println("Le serveur de retour n'a pas pu être créé :");
			System.err.println(ioe3.getMessage());
			return;
		}

	}

}
