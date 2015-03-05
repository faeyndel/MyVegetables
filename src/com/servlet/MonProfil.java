package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

public class MonProfil extends HttpServlet{
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String VUE2          = "/WEB-INF/profileRestoAccount.jsp";
    public static final String VUE1          = "/WEB-INF/profileUserAccount.jsp";
    public static final String Mess          = "message";
 
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
       
    	
    	response.setCharacterEncoding("UTF-8");
    	request.setCharacterEncoding("UTF-8");
    	
    	String type=   request.getParameter("type");

    	
		int particulier = type.compareTo("particulier");
		int restaurant = type.compareTo("restaurant");
		
		if (particulier == 0)
		{
			
			/* Affichage de la page de connexion */
	        this.getServletContext().getRequestDispatcher( VUE1 ).forward( request, response );
		}
		
		if (restaurant == 0)
		{
			
			/* Affichage de la page de connexion */
	        this.getServletContext().getRequestDispatcher( VUE2 ).forward( request, response );
		}
 
        
    }
    
    
    
    
    
 public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
	 
	 
	 response.setCharacterEncoding("UTF-8");
 	  request.setCharacterEncoding("UTF-8");
    	
    	String type2=   request.getParameter("type");

    	String type = type2.trim();
    	
		int particulier = type.compareTo("particulier");
		int restaurant = type.compareTo("restaurant");
		
		if (particulier == 0)
		{
			
			/* Affichage de la page de connexion */
			String message="Bienvenue sur votre profil !";
			request.setAttribute( Mess, message );
	        this.getServletContext().getRequestDispatcher( VUE1 ).forward( request, response );
		}
		
		if (restaurant == 0)
		{
			
			/* Affichage de la page de connexion */
			String message="Bienvenue sur votre profil !";
			request.setAttribute( Mess, message );
	        this.getServletContext().getRequestDispatcher( VUE2 ).forward( request, response );
		}
 
        
    }

}
