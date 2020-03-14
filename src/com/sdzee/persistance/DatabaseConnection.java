package com.sdzee.persistance;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	public static Connection initializeDatabase() 
	        throws SQLException, ClassNotFoundException{
		// Initialize all the information regarding 
        // Database Connection 
		String dbName ="pweb19_leroux"; 
        String SSL="temp?useSSL=false";
        String dbUsername ="root"; 
        String dbPassword =""; 
        
        String dbDriver ="com.mysql.jdbc.Driver"; 
        String dbURL ="jdbc:mysql://localhost:3306/"+dbName+""; 
        // Database name to access 
        
        Class.forName(dbDriver); 
        Connection con =DriverManager.getConnection(dbURL +SSL, dbUsername, dbPassword); 
//        http://localhost/phpmyadmin/index.php?db=pweb19_leroux&target=db_structure.php
        return con;
	}
}
