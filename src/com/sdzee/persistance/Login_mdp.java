package com.sdzee.persistance;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.sdzee.services.EnvoiBDD;

import application.Utilisateur;


public class Login_mdp extends DatabaseConnection{
	
	public List<Utilisateur> recupererUtilisateur(){
		List<Utilisateur>utilisateurs=new ArrayList<Utilisateur>();
		java.sql.Statement statement=null;
		java.sql.ResultSet resultat=null;
		DatabaseConnection.loadDatabase();
		
		try {
			statement= connexion.createStatement();
			
			
			String reqSQL="SELECT u.login,u.mdp FROM utilisateur AS u WHERE u.login="+EnvoiBDD.getLogin()+" AND u.mdp="+EnvoiBDD.getMdp()+";";
			//Exécution de la requête SQL
			resultat= statement.executeQuery(reqSQL);
			
			 
			while (resultat.next()) {
				String login=resultat.getString("u.login");
				String mdp=resultat.getString("u.mdp");
				Utilisateur utilisateur=new Utilisateur();
				utilisateur.setlogin(login);
				utilisateur.setmdp(mdp);
				utilisateurs.add(utilisateur);
				
				
			}
		} catch (SQLException e) {
			e.getMessage();
		}finally {
			try {
				if (resultat!=null) {
					resultat.close();
				}
				if (statement!=null) {
					statement.close();
				}
				if (connexion!=null) {
					connexion.close();
				}
			} catch (SQLException ignore) {
				ignore.getMessage();
			}
		}
		return utilisateurs;
	}
}
