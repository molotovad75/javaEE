package com.sdzee.services;
import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdzee.persistance.Login_mdp;


public class EnvoiBDD extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Login_mdp login_mdp= new Login_mdp();
		login_mdp.recupererUtilisateur(request.getParameter("login"), request.getParameter("mdp"));
		
//		request.setAttribute("login", Login_mdp.getLogin());
//		request.setAttribute("mdp", Login_mdp.getMdp());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/interface.jsp").forward(request, response);
		
		
		
	}


}
