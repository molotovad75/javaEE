package com.sdzee.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Inscription extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

		this.getServletContext().getRequestDispatcher("/WEB-INF/Inscription.jsp").forward(request, response);
	}

}
