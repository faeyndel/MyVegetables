package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.object.User;
import com.model.DAOFactory;
import com.model.UserDao;

public class ListUser extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    public static final String CONF_DAO_FACTORY = "daofactory";
    public static final String List         = "users";
    public static final String VUE              = "/WEB-INF/affichageListe.jsp";

    private UserDao     userDao;

    public void init() throws ServletException {
        /* R�cup�ration d'une instance de notre DAO user */
        this.userDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getUserDao();
    }

    public void doGet(   HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Affichage de la page de la liste des users*/
    	
    	response.setCharacterEncoding("UTF-8");
    	request.setCharacterEncoding("UTF-8");
    	
		List<User> laliste= new  ArrayList<User>();
		laliste=this.userDao.lister();
		request.setAttribute( List, laliste );
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
    
    
	
	

}
