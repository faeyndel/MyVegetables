package com.servlet;

import java.io.IOException;
//import java.util.ArrayList;


import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.*;
import com.object.Resto_Account;
import com.object.User;

public class Connexion extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
    public static final String CONF_DAO_FACTORY = "daofactory";
    public static final String Mess         = "message";
    public static final String Obj         = "objet";
    public static final String userId         = "userId";
    public static final String type         = "type";
    public static final String error         = "erreur";
    public static final String VUE          = "/index.jsp";
    public static final String VUE2          = "/WEB-INF/profileRestoAccount.jsp";
    public static final String VUE1          = "/WEB-INF/profileUserAccount.jsp";

    private UserDao      userDao;

    public void init() throws ServletException {
        /* Récupération d'une instance d'un utilisateur */
        this.userDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getUserDao();
    }

    public void doPost(   HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
	    
    	
    	response.setCharacterEncoding("UTF-8");
    	request.setCharacterEncoding("UTF-8");
    	
		String identifiant=   request.getParameter("adress");
		String accountType= request.getParameter("accountType");
		String password= request.getParameter("passwordLog");
		Resto_Account accountResto = new Resto_Account();		
		User user = new User();		
		
		int particulier = accountType.compareTo("particulier");
		int restaurant = accountType.compareTo("restaurant");
		if (particulier == 0)
		{
			user = this.userDao.verifUser(identifiant,password);
			if (user == null)
			{
				String message = "Login ou mot de passe Incorrect";
				request.setAttribute( error, message );
		        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
			}
			else{
				// Création de la session 
				HttpSession session= request.getSession();
				
				/* Mise en session de mon objet */
				session.setAttribute( Obj,user );
				session.setAttribute( userId,user.getId_user() );
				session.setAttribute( type ,accountType );
			 this.getServletContext().getRequestDispatcher( VUE1 ).forward( request, response );
			 
			}
			
		}
		
		
		if (restaurant == 0)
		{
			accountResto = this.userDao.verifaccountResto(identifiant,password);
			if (accountResto == null)
			{
				String message = "Login ou mot de passe Incorrect";
				request.setAttribute( error, message );
		        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
			}
			else{
				// Création de la session 
				HttpSession session= request.getSession();
				
				/* Mise en session de mon objet */
				
				session.setAttribute( Obj,accountResto );
				session.setAttribute( type ,accountType );
				session.setAttribute( userId,accountResto.getId_resto_account() );
			 this.getServletContext().getRequestDispatcher( VUE2 ).forward( request, response );
			 
			}
			
		}
		
		
		
		
    }
	

}
