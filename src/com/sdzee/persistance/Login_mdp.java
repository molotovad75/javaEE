package com.sdzee.persistance;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import com.sdzee.services.EnvoiBDD;

import application.Utilisateur;


public class Login_mdp extends DatabaseConnection{
	
	private List<Utilisateur>utilisateurs;
	private static String login="";
	private static String mdp="";
	
	
	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}


	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}


	public static String getLogin() {
		return login;
	}


	public static void setLogin(String login) {
		Login_mdp.login = login;
	}


	public static String getMdp() {
		return mdp;
	}


	public static void setMdp(String mdp) {
		Login_mdp.mdp = mdp;
	}


	public List<Utilisateur> recupererUtilisateur(){
		
		utilisateurs=new ArrayList<Utilisateur>();
		Statement statement=null;
		ResultSet resultat=null;
		DatabaseConnection.loadDatabase();
		
		try {
			statement= (Statement) connexion.createStatement();
			
			
			String reqSQL="SELECT u.login,u.mdp FROM utilisateur AS u WHERE u.login="+EnvoiBDD.getLogin()+" AND u.mdp="+EnvoiBDD.getMdp()+";";
			//Exécution de la requête SQL
			resultat= (ResultSet) statement.executeQuery(reqSQL);
			
			 
			while (resultat.next()) {
				login=resultat.getString("u.login");
				mdp=resultat.getString("u.mdp");
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
