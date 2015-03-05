package com.servlet;

import java.io.IOException;
//import java.util.ArrayList;


import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.*;


/**
 * AddRestoForm est la classe représentant un controleur. Elle permet .
 * de transmettre l'id de l'utilisateur (récupérer sur un 
 * formulaire sur la jsp)   au modèle restodao.
 * Ce dernier se chargera de faire la bonne requete associée. 
  * @author team MyVegetable
 * @version 1.0
 * 
 */

public class AddRestoForm extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
    public static final String CONF_DAO_FACTORY = "daofactory";
    public static final String id_user         = "id_user";
    public static final String VUE              = "/ajouterResto.jsp";
    //public static final String Id         		="id"; 

    private RestoDao      restoDao;

    public void init() throws ServletException {
        /* Récupération 
         *  d'une instance de notre DAO Resto */
        this. restoDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getRestoDao();
    }

    public void doPost(   HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
	
    	response.setCharacterEncoding("UTF-8");
    	request.setCharacterEncoding("UTF-8");
    		
    	HttpSession session = request.getSession(false);
    	int  idUser= (Integer) session.getAttribute("userId");
    	//int idUser = Integer.parseInt(idUserS);
		String message=this.restoDao.addRestoForm(idUser);
		request.setAttribute( id_user, message );
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
	

}
