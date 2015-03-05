package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//import java.util.ArrayList;


import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.*;
import com.object.Commentaire;
import com.object.Resto_Profil;

public class AjoutCommentaire extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
    public static final String CONF_DAO_FACTORY = "daofactory";
    public static final String Mess2         = "somme";
    public static final String Mess         =   "message";
    public static final String List         =   "commentaires";
    public static final String Le_resto         = "le_resto";
    public static final String VUE              = "/affichageMessage.jsp";
    public static final String VUE2              = "/detail.jsp";
  

    private CommentDao      commentDao;
    
    private RestoDao      restoDao;

    
    public void init() throws ServletException {
        /* Récupération d'une instance de notre DAO Resto */
        this.commentDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getCommentDao();
        this. restoDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getRestoDao();
    }

    public void doPost(   HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
	
    	// ceci resoud le problème d'encodage
    	response.setCharacterEncoding("UTF-8");
    	request.setCharacterEncoding("UTF-8");
    	
    	String  idUserS=request.getParameter("restoi");
    	int lid = Integer.parseInt(idUserS.trim());
		int 	mark		= 	Integer.parseInt(request.getParameter("mark"));
		String 	pseudo		=  	request.getParameter("pseudo");
		String 	email		=  	request.getParameter("email");
		int 	checksum	=  	Integer.parseInt(request.getParameter("checksum"));
		int 	checksum1	=  	Integer.parseInt(request.getParameter("checksum1"));
		int 	checksum2	=  	Integer.parseInt(request.getParameter("checksum2"));
		String 	comment		=	request.getParameter("comment");
		if((checksum1 + checksum2) == checksum){
			String message=this.commentDao.addComment(mark, pseudo, email, comment, lid);
			/*List<Commentaire> laliste= new  ArrayList<Commentaire>();
			laliste=this.commentDao.lister(lid);
			request.setAttribute( List, laliste );*/
			request.setAttribute( Mess, message );
	        this.getServletContext().getRequestDispatcher( VUE).forward( request, response );
		}else{
			String erreur= "<br>Veuillez verifiez que la somme est exacte <br>";
			erreur+=" ou  que tous les champs sont saisis ";
			request.setAttribute( Mess2, erreur);
			String  idUserS2=request.getParameter("restoi");
	    	int lid2 = Integer.parseInt(idUserS2.trim());
			List<Commentaire> laliste= new  ArrayList<Commentaire>();
			laliste=this.commentDao.lister(lid);
			request.setAttribute( List, laliste );
			Resto_Profil     tempresto=new Resto_Profil();
			tempresto=this.restoDao.editer(lid2);
			request.setAttribute(Le_resto,tempresto );
			this.getServletContext().getRequestDispatcher( VUE2 ).forward( request, response );
		}
		
    }
	

}
