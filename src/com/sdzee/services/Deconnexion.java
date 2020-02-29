package com.sdzee.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Deconnexion extends HttpServlet {
 static final long serialVersionUID = 1L;
 public static final String URL_REDIRECTION = "http://localhost:8080/Projet_JAVA_EE/connexion";

 public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
     /* Récupération et destruction de la session en cours */
     HttpSession session = request.getSession();
     session.invalidate();

     /* Redirection vers la page de connexion ! */
     response.sendRedirect( URL_REDIRECTION );
 }
}
