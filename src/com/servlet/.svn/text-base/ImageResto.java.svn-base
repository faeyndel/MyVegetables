package com.servlet;

import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.foed.bean.offre;
import com.model.DAOFactory;
import com.model.RestoDao;
import com.object.Resto_Photo;

public class ImageResto extends HttpServlet  {
	
	
private static final long serialVersionUID = 1L;
	
    public static final String CONF_DAO_FACTORY = "daofactory";
    public static final String List = "les_photos";
    public static final String VUE              = "/profileRestoAccountImages.jsp";
    public static final String Id         		="id"; 

    private RestoDao     restoDao;

    public void init() throws ServletException {
        /* Récupération d'une instance de notre DAO Resto */
        this. restoDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getRestoDao();
    }

    public void doPost(   HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	 /* Affichage de la page de correspondant a une offre choisie*/
   	 //DAOFactory tempdaofac=(DAOFactory) this.offreDao;
    	response.setCharacterEncoding("UTF-8");
    	request.setCharacterEncoding("UTF-8");
    	
		//int  lid= Integer.parseInt(request.getParameter(Id));
		String  idUserS=request.getParameter("comptei");
    	int lid = Integer.parseInt(idUserS.trim());
		Resto_Photo laliste= new  Resto_Photo();
		laliste=this.restoDao.getPhoto(lid);
		request.setAttribute( List, laliste );
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
    

}
