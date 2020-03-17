package com.sdzee.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Servlet pour la connexion
public class Connexion extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	/*On va chercher le fichier JSP pour afficher la page. 
	*Le client passe à travers cette méthode obligatoirement par cette servlet.
	*/
	public Connexion() {
		super();
	}
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
//		String message = "Transmission de variables : OK !";
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Connexion.jsp").forward(request, response);
		
	}

}
