package com.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.*;

public class UpdateResto extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
    public static final String CONF_DAO_FACTORY = "daofactory";
    public static final String Mess         = "message";
    public static final String VUE              = "/UpdateMessage.jsp";
    public static final String Id           ="id";     

    private RestoDao      restoDao;

    public void init() throws ServletException {
        /* R�cup�ration d'une instance de notre DAO Resto */
        this. restoDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getRestoDao();
    }

    public void doPost(   HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	response.setCharacterEncoding("UTF-8");
    	request.setCharacterEncoding("UTF-8");

    	String  idUserS=request.getParameter("restoi");
    	int lid = Integer.parseInt(idUserS.trim());
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
		String message=this.restoDao.update_resto(nom, adresse, ville, codepostale, tel, courriel, des, horaire, prix, url,siren,menu,Latitude, Longitude, lid);
		request.setAttribute( Mess, message );
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
	

}
