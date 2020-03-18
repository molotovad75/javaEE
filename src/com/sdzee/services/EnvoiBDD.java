package com.sdzee.services;
import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdzee.persistance.Login_mdp;

import application.Utilisateur;



public class EnvoiBDD extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String login="";
	private static String mdp="";
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		 try {
//			 
//				Connection con = (Connection) DatabaseConnection.initializeDatabase();
				setLogin(request.getParameter("login"));
				setMdp(request.getParameter("mdp"));
//				// Create a SQL query to insert data into demo table 
//	            // demo table consists of two columns, so two '?' is used 
//				String reqSQL="SELECT u.login,u.mdp FROM utilisateur AS u WHERE u.login=? AND u.mdp=?";
//	            PreparedStatement st = con.prepareStatement(reqSQL); 
//	            // For the first parameter, 
//	            // get the data using request object 
//	            // sets the data to st pointer 
//	            st.setString(1,String.valueOf(login)); 
//	            // Same for second parameter 
//	            st.setString(2,String.valueOf(mdp)); 
//	  
//	            // Execute the query command using executeQuery()  
//	            ResultSet rs =  st.executeQuery(reqSQL); 
//	           
//	            while (rs.next()) {
//					String loginUtilisateur=rs.getString("u.login");
//					String mdpUtilisateur=rs.getString("u.mdp");
//					String message="";
//				if (loginUtilisateur.equals(login)==true && mdpUtilisateur.equals(mdp)==true) {
//					message="Successfully Connected";
//					request.setAttribute("login_mdp",message);
//					this.getServletContext().getRequestDispatcher("/WEB-INF/Connexion.jsp").forward(request, response); 
//	            	 
//				}else {
//						message="Login ou Mot de passe incorrect";
//						request.setAttribute("login_mdp",message);
//						this.getServletContext().getRequestDispatcher("/WEB-INF/Connexion.jsp").forward(request, response); 
//					}
//				}
//	          
//	            // Close all the connections 
//	            st.close(); 
//	            con.close(); 		
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.getMessage();
//			}
		
		
		
//		login=request.getParameter("login");
//		mdp=request.getParameter("mdp");
//		String message="Votre login est "+login+" et votre mot de passe est "+mdp;
//		request.setAttribute("login_mdp",message);
				
		Login_mdp login_mdp= new Login_mdp();
		login_mdp.recupererUtilisateur();
		request.setAttribute("login", Login_mdp.getLogin());
		request.setAttribute("mdp", Login_mdp.getMdp());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Connexion.jsp").forward(request, response);
	}

	public static String getLogin() {
		return login;
	}

	public static void setLogin(String login) {
		EnvoiBDD.login = login;
	}

	public static String getMdp() {
		return mdp;
	}

	public static void setMdp(String mdp) {
		EnvoiBDD.mdp = mdp;
	}

}
