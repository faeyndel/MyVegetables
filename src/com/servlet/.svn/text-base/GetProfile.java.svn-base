package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.foed.bean.offre;
import com.model.DAOFactory;
import com.model.UserDao;
import com.object.User;

public class GetProfile extends HttpServlet  {
	
	
private static final long serialVersionUID = 1L;
	
    public static final String CONF_DAO_FACTORY = "daofactory";
    public static final String info_utilisateur = "info_utilisateur";
    public static final String VUE              = "/profileUserAccount.jsp";
    public static final String Id         		="id"; 

    private UserDao     userDao;

    public void init() throws ServletException {
        /* R�cup�ration d'une instance de notre DAO Resto */
        this. userDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getUserDao();
    }

    public void doGet(   HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	 /* Affichage de la page de correspondant a une offre choisie*/
   	 //DAOFactory tempdaofac=(DAOFactory) this.offreDao;
    	
    	response.setCharacterEncoding("UTF-8");
    	request.setCharacterEncoding("UTF-8");
		//int  lid= Integer.parseInt(request.getParameter(Id));
    	HttpSession session = request.getSession(false);
    	int  lid= (Integer) session.getAttribute("userId");
		User     tempuser=new User();
		tempuser=this.userDao.editer(lid);
		request.setAttribute(info_utilisateur,tempuser );
       this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
    

}
