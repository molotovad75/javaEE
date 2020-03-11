package com.sdzee.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.sdzee.persistance.DatabaseConnection;

@WebServlet("/VerifBDD") 
public class VerifBDD extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		try {
			
			String login=request.getParameter("login");	
			String mdp=request.getParameter("mdp");
			request.setAttribute("login", login);
			request.setAttribute("password", mdp);
			System.out.println(login+"    "+mdp);
			//Vérifier en BDD que login +mdp soient corrects
			
			
			Connection con = (Connection) DatabaseConnection.initializeDatabase();
			
			// Create a SQL query to insert data into demo table 
            // demo table consists of two columns, so two '?' is used 
			String reqSQL="SELECT u.login,u.mdp FROM utilisateur AS u WHERE u.login=? AND u.mdp=?";
            PreparedStatement st = con.prepareStatement(reqSQL); 
  
            // For the first parameter, 
            // get the data using request object 
            // sets the data to st pointer 
            st.setString(1,login); 
  
            // Same for second parameter 
            st.setString(2, mdp); 
  
            // Execute the query command using executeQuery()  
            ResultSet rs =  st.executeQuery(reqSQL); 
            PrintWriter out = response.getWriter();
            while (rs.next()) {
				String loginUtilisateur=rs.getString("u.login");
				String mdpUtilisateur=rs.getString("u.mdp");
				if (loginUtilisateur.equals(login)==true && mdpUtilisateur.equals(mdp)==true) {
					this.getServletContext().getRequestDispatcher("/WEB-INF/Connexion.jsp").forward(request, response);
	            	 out.println("<html><body><b>Successfully Connected"
	                         + "</b></body></html>");
				}else {
					 // Get a writer pointer  
		            // to display the successful result 
					this.getServletContext().getRequestDispatcher("/WEB-INF/Connexion.jsp").forward(request, response);
					 out.println("<html><body><b>Login ou Mot de passe incorrect"
		                        + "</b></body></html>");
				}
			}
            
            // Close all the connections 
            st.close(); 
            con.close(); 		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	 

}
