package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.foed.bean.offre;
import com.model.DAOFactory;
import com.model.RestoDao;
import com.object.Resto_Profil;

public class EditerResto extends HttpServlet  {
	
	
private static final long serialVersionUID = 1L;
	
    public static final String CONF_DAO_FACTORY = "daofactory";
    public static final String Le_resto         = "le_resto";
    public static final String VUE              = "/editerResto.jsp";
    public static final String Id           ="id"; 

    private RestoDao     restoDao;

    public void init() throws ServletException {
        /* R�cup�ration d'une instance de notre DAO Resto */
        this. restoDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getRestoDao();
    }

    public void doPost(   HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	 /* Affichage de la page de correspondant a une offre choisie*/
   	 //DAOFactory tempdaofac=(DAOFactory) this.offreDao;
    	
    	response.setCharacterEncoding("UTF-8");
    	request.setCharacterEncoding("UTF-8");
    	
		String  idUserS=request.getParameter("comptei");
    	int lid = Integer.parseInt(idUserS.trim());
    	//HttpSession session = request.getSession(false);
    	//int  lid= (Integer) session.getAttribute("userId");
		Resto_Profil     tempresto=new Resto_Profil();
		tempresto=this.restoDao.editer(lid);
		request.setAttribute(Le_resto,tempresto );
       this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
    

}
