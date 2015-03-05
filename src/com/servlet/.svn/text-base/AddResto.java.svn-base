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
 * AddResto est la classe représentant un controleur. Elle permet .
 * de recupérer kles informations d'un restaurants sur una page jsp, les transmettre 
 *  aux modèle restodao. et enfin renvoie un message de confirmation d'ajout ou un message 
 *  d'erreur sur la ge jsp UpdateMessage.jsp
 * Ce dernier se chargera de les insérer en base 
  * @author team MyVegetable
 * @version 1.0
 * 
 */

public class AddResto extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
    public static final String CONF_DAO_FACTORY = "daofactory";
    public static final String Mess         = "message";
    public static final String VUE              = "/UpdateMessage.jsp";
    public static final String Id         		="id"; 

    private RestoDao      restoDao;

    public void init() throws ServletException {
        /* R�cup�ration d'une instance de notre DAO Resto */
        this. restoDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getRestoDao();
    }

    public void doPost(   HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
	    
    	
    	response.setCharacterEncoding("UTF-8");
    	request.setCharacterEncoding("UTF-8");
    	
    	HttpSession session = request.getSession(false);
    	int  idUser= (Integer) session.getAttribute("userId");
		String nom=     request.getParameter("name");
		String adresse= request.getParameter("adress");
		String ville=   request.getParameter("city");
		String siren=   request.getParameter("siren");
		int codepostale= Integer.parseInt(request.getParameter("pobox"));
		String tel=  request.getParameter("phone");
		String courriel= request.getParameter("email");
		String des= request.getParameter("description");
		String horaire= request.getParameter("horaire"); 
		String menu= request.getParameter("menu"); 
		String Latitude= request.getParameter("Latitude");
		String Longitude= request.getParameter("Longitude");
		int prix= Integer.parseInt(request.getParameter("prix"));
		String url = request.getParameter("url");		
		String message=this.restoDao.ajout_resto(idUser, nom, adresse, ville, codepostale, tel, courriel, des, horaire, prix, url,siren, menu, Latitude, Longitude);
		request.setAttribute( Mess, message );
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
	

}
