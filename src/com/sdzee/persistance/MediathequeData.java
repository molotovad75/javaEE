package com.sdzee.persistance;
import java.util.ArrayList;
import mediatek2020.PersistentMediatheque;
import mediatek2020.items.Document;
import mediatek2020.items.Utilisateur;

public class MediathequeData implements PersistentMediatheque{
	
	 ArrayList<Document> documents=new ArrayList<Document>();

	public String toString() {
		return documents.toString(); 
	}
	
	@Override
	public Utilisateur getUser(String login, String password) {
		
		return null;
	}

	@Override
	public Document getDocument(int arg0) {
		
		return null;
	}

	@Override //Object... arg1  est �quivalent � un tableau (Object[] arg1) La taille de ce tableau est unconnue.
	public void nouveauDocument(int arg0, Object... arg1) {
		//Peut �tre que arg0 est le nombre de documents que l'on souhaite mettre dans la biblioth�que.
		arg1=documents.toArray(arg1); //Converti le tableau en arraylist.
		
		arg0=arg1.length;
		for (int i = 0; i < arg1.length; i++) {
			
		}
		
	}

	@Override
	public ArrayList<Document> tousLesDocuments() {

		return documents;
	}
	
}
