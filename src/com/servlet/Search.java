package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.*;
import com.object.Resto_Profil;

public class Search extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
    public static final String CONF_DAO_FACTORY = "daofactory";
    public static final String list         = "search_restos";
    public static final String VUE              = "/search.jsp";
    public static final String VUE2              = "/search.jsp";

    private RestoDao      restoDao;

    public void init() throws ServletException {
        /* R�cup�ration d'une instance de notre DAO Resto */
        this. restoDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getRestoDao();
    }

    public void doPost(   HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        
    	
    	response.setCharacterEncoding("UTF-8");
    	request.setCharacterEncoding("UTF-8");
    	
    	String  restoName = request.getParameter("Restaurant");
    	String  restoAdress = request.getParameter("Adresse");
    	String  restoCityZip = request.getParameter("VilleCP");
    	
    	if (restoName != "" || restoAdress != "" || restoCityZip != ""){
    		List<Resto_Profil> laliste= new  ArrayList<Resto_Profil>();
    		laliste=this.restoDao.search( restoName, restoAdress, restoCityZip);

    		request.setAttribute( list, laliste );
            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    	}else{
    		this.getServletContext().getRequestDispatcher( VUE2 ).forward( request, response );
    	}
    }
	

}
