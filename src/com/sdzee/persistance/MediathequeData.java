package com.sdzee.persistance;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import mediatek2020.PersistentMediatheque;
import mediatek2020.items.Document;
import mediatek2020.items.Utilisateur;

public class MediathequeData implements PersistentMediatheque{
	 private Connection connexion;
	 ArrayList<Document> documents=new ArrayList<Document>();

	public String toString() {
		return documents.toString(); 
	}
	
	@Override
	public Utilisateur getUser(String login, String password) {
		String requeteSQL="SELECT u.name u.email FROM utilisateur AS u WHERE u.login="+login+" AND u.mdp="+password+"; ";
		try {
			
		} catch (Exception e) {
			
		}finally {
			
		}
		return null;
	}

	@Override
	public Document getDocument(int arg0) {
		//int arg0 siginifie probablement le numéro du document.
		//Cd DVD ou livre peuvent être des documens.
		String requeteSQL="SELECT l.titre_livre,d.titre_dvd,c.titre_cd FROM livre AS l, dvd AS d, cd AS c WHERE l.idlivre="+arg0+" OR d.iddvd="+arg0+" OR c.idcd="+arg0+"; ";
		
		return null;
	}

	@Override //Object... arg1  est équivalent à un tableau (Object[] arg1) La taille de ce tableau est inconnue.
	public void nouveauDocument(int arg0, Object... arg1) {
		//Peut être que arg0 est le nombre de documents que l'on souhaite mettre dans la bibliothèque.
		//ou bien, arg0 siginifie simplement le numéro du document.
		
		arg1=documents.toArray(arg1); //Converti le tableau en arraylist.
		
		arg0=arg1.length;
		for (int i = 0; i < arg1.length; i++) {
			
		}
		
	}

	@Override
	public ArrayList<Document> tousLesDocuments() {

		return documents;
	}
	
	private void loadDatabase() {
        // Chargement du driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
               e.getMessage();
        }

        try {
            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pweb19_leroux","root","");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
