package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.CommentDao;
//import com.foed.bean.offre;
import com.model.DAOFactory;
import com.model.RestoDao;
import com.object.Commentaire;
import com.object.Resto_Profil;

public class DetailResto extends HttpServlet  {
	
	
private static final long serialVersionUID = 1L;
	
    public static final String CONF_DAO_FACTORY = "daofactory";
    public static final String Le_resto         = "le_resto";
    public static final String List         =   "commentaires";
    public static final String VUE              = "/detail.jsp";
    

    private RestoDao     restoDao;
    private CommentDao      commentDao;

    public void init() throws ServletException {
        /* Récupération d'une instance de notre DAO Resto */
        this. restoDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getRestoDao();
        this.commentDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getCommentDao();
    }

    public void doPost(   HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	 /* Affichage de la page de correspondant a une offre choisie*/
   	 //DAOFactory tempdaofac=(DAOFactory) this.offreDao;
    	
    	response.setCharacterEncoding("UTF-8");
    	request.setCharacterEncoding("UTF-8");
    	
    	String  idUserS=request.getParameter("restoi");
    	int lid = Integer.parseInt(idUserS.trim());
		Resto_Profil     tempresto=new Resto_Profil();
		tempresto=this.restoDao.restoProfil(lid);
		List<Commentaire> laliste= new  ArrayList<Commentaire>();
		laliste=this.commentDao.lister(lid);
		request.setAttribute( List, laliste );
		request.setAttribute(Le_resto,tempresto );
       this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
    

}
