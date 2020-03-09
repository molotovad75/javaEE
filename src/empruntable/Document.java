package empruntable;

import java.time.LocalDateTime;

import instanciable.Abonne;

public interface Document {
	
	int numero();
	void reserver(Abonne ab) throws EmpruntException;
	void emprunter(Abonne ab) throws EmpruntException;
	// retour document ou annulation réservation
	void retour() throws RetourException;
	
	//ajouts personnels autorisés
	String titre();
	Etat statut();
	LocalDateTime dateEmprunt();
	Abonne possesseur();
	boolean estRéservé();
	boolean estEmprunté();
	boolean estDispo();

}
