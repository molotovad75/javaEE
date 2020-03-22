package com.sdzee.persistance;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {
//	private static Connection connexion;
//	
//	public static Connection getConnexion() {
//		return connexion;
//	}
//
//	static {
//        // Chargement du driver
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            connexion = DriverManager.getConnection
//            		("jdbc:mysql://localhost:3306/pweb19_leroux?autoReconnect=true&useSSL=false","root","");
//        } catch (Exception e) {
//               e.getMessage();
//        }
//
//
//    }
	
	public static Connection connexionBDD(String nomHote,String nomBDD, String nomUtilisateur,String mdp) throws SQLException,ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String connectionURL="jdbc:mysql://"+nomHote+":3306/"+nomBDD+"?autoReconnect=true&useSSL=false";
		Connection conn=DriverManager.getConnection(connectionURL,nomUtilisateur,mdp);
		return conn;
	}
	public static Connection connexionBDD() throws ClassNotFoundException,SQLException{
		String nomHote="localhost";
		String nomBDD="pweb19_leroux";
		String nomUtilisateur="root";
		String mot_de_passe="";
		return connexionBDD(nomHote,nomBDD,nomUtilisateur,mot_de_passe);
	}

		
	public static Connection getConnexion()throws ClassNotFoundException,SQLException{
		return connexionBDD();
	}
	
	public static void fermer(Connection conn) {
		try {
			
			conn.close();
		}catch (Exception e) {
			e.getMessage();
		}
	}
	
	
	
	
	
}
