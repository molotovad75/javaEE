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
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Login_mdp login_mdp= new Login_mdp();
		login_mdp.recupererUtilisateur(request.getParameter("login"), request.getParameter("mdp"));
		
//		request.setAttribute("login", Login_mdp.getLogin());
//		request.setAttribute("mdp", Login_mdp.getMdp());
		
		if (request.getParameter("login").compareTo(Login_mdp.getLogin())==0 
				&& request.getParameter("mdp").compareTo(Login_mdp.getMdp())==0) {
			
			System.out.println("sss");
			this.getServletContext().getRequestDispatcher("/WEB-INF/Mdp_oublié.jsp").forward(request, response);
		}else {
			System.out.println("utu");
			this.getServletContext().getRequestDispatcher("/WEB-INF/Connexion.jsp").forward(request, response);
			
		}
	
		
	}


}
