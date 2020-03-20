package com.sdzee.persistance;
import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseConnection {
	private static Connection connexion;
	
	public static Connection getConnexion() {
		return connexion;
	}

	static {
        // Chargement du driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connexion = DriverManager.getConnection
            		("jdbc:mysql://localhost:3306/pweb19_leroux?autoReconnect=true&useSSL=false","root","");
        } catch (Exception e) {
               e.getMessage();
        }


    }
}
