package com.sdzee.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sdzee.beans.Utilisateur;


public class Login_mdp extends DatabaseConnection{
	
	
	
	
	
	private List<Utilisateur>utilisateurs;
	private static String login="";
	private static String mdp="";
	
	public List<Utilisateur> recupererUtilisateur(String login,String mdp){
		List<Utilisateur> user=new ArrayList<Utilisateur>();
		Connection conn = null;
		try {
			conn = DatabaseConnection.getConnexion();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			PreparedStatement ps=conn.prepareStatement("SELECT u.login,u.mdp FROM utilisateur AS u WHERE u.login=? AND u.mdp=?");
			ps.setString(1, login);
			ps.setString(2, mdp);
			java.sql.ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Utilisateur utilisateur=new Utilisateur();
				utilisateur.setlogin(rs.getString("login"));
				utilisateur.setmdp(rs.getString("mdp"));
				user.add(utilisateur);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		setLogin(login);
		setMdp(mdp);
		return user;
	}
	
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
	
	
}
