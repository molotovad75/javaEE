package empruntable;

import java.time.LocalDateTime;

import instanciable.Abonne;

public interface Document {
	
	int numero();
	void reserver(Abonne ab) throws EmpruntException;
	void emprunter(Abonne ab) throws EmpruntException;
	// retour document ou annulation r�servation
	void retour() throws RetourException;
	
	//ajouts personnels autoris�s
	String titre();
	Etat statut();
	LocalDateTime dateEmprunt();
	Abonne possesseur();
	boolean estR�serv�();
	boolean estEmprunt�();
	boolean estDispo();

}
