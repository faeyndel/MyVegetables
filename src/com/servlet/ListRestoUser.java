package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.DAOFactory;
import com.model.RestoDao;
import com.model.UserDao;
import com.object.Resto_Profil;
//import com.object.User;

public class ListRestoUser extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
    public static final String CONF_DAO_FACTORY = "daofactory";
    public static final String List         = "mes_restos";
    public static final String VUE              = "/profileRestoAccountList.jsp";
    public static final String Id           ="id";

    private RestoDao     restoDao;

    public void init() throws ServletException {
        /* R�cup�ration d'une instance de notre DAO Resto */
        this. restoDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getRestoDao();
    }

    public void doPost(   HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Affichage de la page de la liste des users*/
    	response.setCharacterEncoding("UTF-8");
    	request.setCharacterEncoding("UTF-8");
    	
		List<Resto_Profil> laliste= new  ArrayList<Resto_Profil>();
		//int  lid= Integer.parseInt(request.getParameter(Id));
		//String  idUserS=request.getParameter("resto");
    	//int lid = Integer.parseInt(idUserS.trim());
		HttpSession session = request.getSession(false);
    	int  lid= (Integer) session.getAttribute("userId");
		laliste=this.restoDao.listerestoUser(lid);
		request.setAttribute( List, laliste );
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
    

}
