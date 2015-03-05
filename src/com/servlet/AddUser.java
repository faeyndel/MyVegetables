package com.servlet;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.*;


/**
 * AddUser est la classe représentant un controleur. Elle permet .
 * de recupérer les informations d'un utilisateur sur una page jsp, les transmettre 
 * aux modèle userdao. et enfin renvoie un message de confirmation d'ajout ou un message 
 * d'erreur sur la  jsp de connexion
 * Ce dernier se chargera de les insérer en base 
 * @author team MyVegetable
 * @version 1.0
 * 
 */

public class AddUser extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
    public static final String CONF_DAO_FACTORY = "daofactory";
    public static final String Mess         = "message";
    public static final String error         = "subscribeError";
    //public static final String VUE              = "/affichageMessage.jsp";
    public static final String VUE              = "/index.jsp";

    private UserDao      userDao;

    public void init() throws ServletException {
        /* Récupération d'une instance de notre DAO Resto */
        this.userDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getUserDao();
    }

    public void doPost(   HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
	   
    	
    	response.setCharacterEncoding("UTF-8");
    	request.setCharacterEncoding("UTF-8");
    	//*******recupération des paramètres d'ajout*************//
    	
		String nom=     request.getParameter("name");
		String prenom= request.getParameter("Prenom");
		String identifiant=   request.getParameter("login");
		String courriel= request.getParameter("email");
		String tel=  request.getParameter("tel");
		String accountType= request.getParameter("accountType");
		String password= request.getParameter("password");
		String password2= request.getParameter("password2"); 
		
		//******Fin de récupération des paramètres***************//
		
		String message = "";
		
		int pass = password.compareTo(password2);
		int particulier = accountType.compareTo("particulier");
		int restaurant = accountType.compareTo("restaurant");
		
		if(pass == 0 && particulier == 0){
			message=this.userDao.addUser(nom, prenom, identifiant, tel, password, courriel);
		}else if(pass == 0 && restaurant == 0){
			message=this.userDao.addUserResto(nom, prenom, identifiant, tel, password, courriel);
		}else{
			message="pwd";
		}
		
		if(message == ""){
			message="Un compte avec le même identifiant ou email est déjà existant.";
			request.setAttribute( error, message );
	        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
		}else if(message == "pwd"){
			message="Mots de passe différents.";
			request.setAttribute( error, message );
	        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
		}else{
			request.setAttribute( Mess, message );
	        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
		}

    }
}
