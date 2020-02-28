package com.sdzee.persistance;
import java.util.List;
import mediatek2020.PersistentMediatheque;
import mediatek2020.items.Document;
import mediatek2020.items.Utilisateur;

public class MediathequeData implements PersistentMediatheque{

	@Override
	public Utilisateur getUser(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getDocument(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void nouveauDocument(int arg0, Object... arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Document> tousLesDocuments() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
