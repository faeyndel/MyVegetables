package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.model.CommentDao;
import com.model.DAOException;
//import com.foed.bean.offre;
import com.model.DAOFactory;
import com.model.RestoDao;
import com.object.Commentaire;
import com.object.Resto_Profil;

public class MapsResto extends HttpServlet  {
	
	
private static final long serialVersionUID = 1L;
	
    public static final String CONF_DAO_FACTORY = "daofactory";
    public static final String JSON         =   "json";
    public static final String VUE              = "/maps.jsp";
    private RestoDao     restoDao;
   

    public void init() throws ServletException {
        /* R�cup�ration d'une instance de notre DAO Resto */
        this. restoDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getRestoDao();        
    }

    public void doGet(   HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	 /* Affichage de la page de correspondant a une offre choisie*/
   	 //DAOFactory tempdaofac=(DAOFactory) this.offreDao;
    	
    	response.setCharacterEncoding("UTF-8");
    	request.setCharacterEncoding("UTF-8");
    			
    	JSONObject json=new JSONObject();

	    try {
			json=this.restoDao.listRestoJson ( );
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute( JSON, json );
       this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
    

}
