package com.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.*;

public class Unsubscribe extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
    public static final String CONF_DAO_FACTORY = "daofactory";
    public static final String Mess         = "message";
    public static final String VUE              = "/desinscription.jsp";
    public static final String Id           ="id";
    public static final String Compte           ="compte"; 

    private UserDao      userDao;

    public void init() throws ServletException {
        /* Récupération d'une instance de notre DAO Resto */
        this. userDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getUserDao();
    }

    public void doPost(   HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	
    	response.setCharacterEncoding("UTF-8");
    	request.setCharacterEncoding("UTF-8");
    	
    	String  lcompte=request.getParameter("compte");
    	String  idUserS=request.getParameter("comptei");
    	int lid = Integer.parseInt(idUserS.trim());
		String message=this.userDao.unsubscribe( lcompte, lid);
		request.setAttribute( Mess, message );
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
    
    public void doGet(   HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	
    	response.setCharacterEncoding("UTF-8");
    	request.setCharacterEncoding("UTF-8");
    		
    	String  lcompte=request.getParameter(Compte);
    	String  idUserS=request.getParameter(Id);
    	int lid = Integer.parseInt(idUserS.trim());
		String message=this.userDao.unsubscribe( lcompte, lid);
		request.setAttribute( Mess, message );
		
		HttpSession session = request.getSession();
        session.invalidate();
		
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
	

}
