package com.sdzee.persistance;
import java.sql.*;
import java.util.ArrayList;

import empruntable.AbonneException;
import mediatek2020.PersistentMediatheque;
import mediatek2020.items.Document;
import mediatek2020.items.Utilisateur;

public class MediathequeData implements PersistentMediatheque{
	 private ResultSet resultat=null;
	 
	 ArrayList<Document> documents=new ArrayList<Document>();

	public String toString() {
		return documents.toString(); 
	}
	
	@Override
	public Utilisateur getUser(String login, String password) {
		
		return new Utilisateur() {

			@Override
			public Object[] data() {
				//retourner un tableau d'objets.
				
				return data();
			}

			@Override
			public boolean isBibliothecaire() {
				return com.sdzee.beans.Utilisateur.isEstbiblio();
			}

			@Override
			public String name() {
				String requeteSQL="SELECT u.name u.email u.bibliothecaire "
						+ "FROM utilisateur AS u "
						+ "WHERE u.login=? AND u.mdp=?;";
				com.sdzee.beans.Utilisateur user=null;
				try {
					Connection conn=DatabaseConnection.getConnexion();
					PreparedStatement ps=conn.prepareStatement(requeteSQL);
					ps.setString(1, login);
					ps.setString(2, password);
					resultat=ps.executeQuery(requeteSQL);
					while(resultat.next()) {
						String nomUtilisateur=resultat.getString("u.name");
						String emailUtilisateur=resultat.getString("u.email");
						int bibliothecaire=resultat.getInt("u.bibliothecaire");
						user=new com.sdzee.beans.Utilisateur();
						user.setNom(nomUtilisateur);
						user.setEmail(emailUtilisateur);
						user.setBiblio(bibliothecaire);
						if (user.getBiblio()==1) {
							com.sdzee.beans.Utilisateur.setEstbiblio(true);
						}else if(user.getBiblio()==0) {
							com.sdzee.beans.Utilisateur.setEstbiblio(false);
						}
					}
				} catch (Exception e) {
					e=new AbonneException("Les données de cet utilisateur n'ont pas pu être trouvés réessayer !");
				}
				return user.getNom();
			}
		};		
	}

	@Override
	public Document getDocument(int arg0) {
		//int arg0 siginifie probablement le numéro du document.
		//Cd DVD ou livre peuvent être des documents.
		String requeteSQL="SELECT l.titre_livre,a.nomauteur,a.prenomauteur,d.titre_dvd,c.titre_cd "
				+ "FROM livre AS l, dvd AS d, cd AS c, auteur AS a "
				+ "WHERE (l.idlivre=? OR d.iddvd=? OR c.idcd=?) "
						+ "AND (a.idauteur=l.idauteur OR a.idauteur=d.idauteur OR a.idauteur=c.idauteur);";
		com.sdzee.beans.Document docLivre=null,docCD=null,docDVD=null;
		try {
			Connection conn=DatabaseConnection.getConnexion();
			PreparedStatement ps=conn.prepareStatement(requeteSQL);
			ps.setInt(1,arg0);
			ps.setInt(2,arg0);
			ps.setInt(3,arg0);
			resultat=ps.executeQuery(requeteSQL);
			while(resultat.next()) {
				String titre_livre=resultat.getString("l.titre_livre"),
				titre_dvd=resultat.getString("d.titre_dvd"),
				titre_cd=resultat.getString("c.titre_cd"),	
				nom_auteur=resultat.getString("a.nomauteur"),
				prenom_auteur=resultat.getString("a.prenomauteur");
				docLivre=new com.sdzee.beans.Livre();
				docCD=new com.sdzee.beans.CD();
				docDVD=new com.sdzee.beans.DVD();
				((com.sdzee.beans.Livre) docLivre).setTitre(titre_livre);
				((com.sdzee.beans.DVD) docDVD).setTitre(titre_dvd);
				((com.sdzee.beans.CD) docCD).setTitre(titre_cd);
				((com.sdzee.beans.Livre) docLivre).setAuteurLivre(nom_auteur,prenom_auteur);
				
			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		//Récupération des données.
//        try {
//			while (resultat.next()) {
//				String nom_livre=resultat.getString("l.titre_livre");
//				String nom_auteur=resultat.getString("a.nomauteur");
//				String nom_dvd=resultat.getString("d.titre_dvd");
//				String nom_cd=resultat.getString("c.titre_cd");
//				Livre livre=new Livre(nom_livre,nom_auteur);
//				DVD dvd=new DVD(nom_dvd,nom_auteur);
//				CD cd=new CD();
//				documents.add((Document) livre);
//				documents.add((Document) dvd);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		return null;
	}

	@Override //Object... arg1  est équivalent à un tableau (Object[] arg1) La taille de ce tableau est inconnue.
	public void nouveauDocument(int arg0, Object... arg1) {
		//Peut être que arg0 est le nombre de documents que l'on souhaite mettre dans la bibliothèque.
		//ou bien, arg0 siginifie simplement le numéro du document.
		
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
