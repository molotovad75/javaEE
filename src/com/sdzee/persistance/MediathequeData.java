package com.sdzee.persistance;
import java.sql.*;
import java.util.ArrayList;

import empruntable.AbonneException;
import instanciable.Abonne;
import instanciable.DVD;
import instanciable.Livre;
import mediatek2020.PersistentMediatheque;
import mediatek2020.items.Document;
import mediatek2020.items.Utilisateur;

public class MediathequeData implements PersistentMediatheque{
	 private Connection connexion=null;
	 private Statement statement=null;
	 private ResultSet resultat=null;
	 
	 ArrayList<Document> documents=new ArrayList<Document>();

	public String toString() {
		return documents.toString(); 
	}
	
	@Override
	public Utilisateur getUser(String login, String password) {
		String requeteSQL="SELECT u.name u.email FROM utilisateur AS u WHERE u.login="+login+" AND u.mdp="+password+"; ";
		try {
			
		} catch (Exception e) {
			e=new AbonneException("Les donn�es de cet utilisateur n'ont pas pu �tre trouv�s r�essayer !");
		}finally {
			return null;
		}
		
	}

	@Override
	public Document getDocument(int arg0) {
		//int arg0 siginifie probablement le num�ro du document.
		//Cd DVD ou livre peuvent �tre des documens.
		String requeteSQL="SELECT l.titre_livre,a.nomauteur,a.prenomauteur,d.titre_dvd,c.titre_cd "
				+ "FROM livre AS l, dvd AS d, cd AS c, auteur AS a "
				+ "WHERE (l.idlivre="+arg0+" OR d.iddvd="+arg0+" OR c.idcd="+arg0+") "
						+ "AND (a.idauteur=l.idauteur OR a.idauteur=d.idauteur OR a.idauteur=c.idauteur);";
		DatabaseConnection.loadDatabase();
		
		//R�cup�ration des donn�es.
        try {
			while (resultat.next()) {
				String nom_livre=resultat.getString("l.titre_livre");
				String nom_auteur=resultat.getString("a.nomauteur");
				String nom_dvd=resultat.getString("d.titre_dvd");
				String nom_cd=resultat.getString("c.titre_cd");
				Livre livre=new Livre(nom_livre,nom_auteur);
				DVD dvd=new DVD(nom_dvd,nom_auteur);
				documents.add((Document) livre);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override //Object... arg1  est �quivalent � un tableau (Object[] arg1) La taille de ce tableau est inconnue.
	public void nouveauDocument(int arg0, Object... arg1) {
		//Peut �tre que arg0 est le nombre de documents que l'on souhaite mettre dans la biblioth�que.
		//ou bien, arg0 siginifie simplement le num�ro du document.
		
//		arg1=documents.toArray(arg1); //Converti le tableau en arraylist.
//		
//		arg0=arg1.length;
//		for (int i = 0; i < arg1.length; i++) {
//			
//		}
		
	}

	@Override
	public ArrayList<Document> tousLesDocuments() {

		return documents;
	}
	
	
}
