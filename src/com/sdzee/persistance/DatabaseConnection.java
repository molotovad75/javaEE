package com.sdzee.persistance;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {
	protected static Connection connexion;
	public static void loadDatabase() {
        // Chargement du driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
               e.getMessage();
        }

        try {
            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pweb19_leroux?autoReconnect=true&useSSL=false","root","");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
