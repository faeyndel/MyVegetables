package com.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.*;

public class UpdateUserPw extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
    public static final String CONF_DAO_FACTORY = "daofactory";
    public static final String Mess         = "message";
    public static final String VUE              = "/UpdateMessage.jsp";
   

    private UserDao      userDao;

    public void init() throws ServletException {
        /* R�cup�ration d'une instance de notre DAO Resto */
        this.userDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getUserDao();
    }

    public void doPost(   HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	response.setCharacterEncoding("UTF-8");
    	request.setCharacterEncoding("UTF-8");
    	
    	
    	//String  idUserS=request.getParameter("comptei");
    	//int lid = Integer.parseInt(idUserS.trim());
    	HttpSession session = request.getSession(false);
    	int  lid= (Integer) session.getAttribute("userId");
		String oldpass=  request.getParameter("oldpassword");
		String npass=  request.getParameter("password");
		String npass2=  request.getParameter("password2");
		
		String message=this.userDao.update_user_pw(oldpass, npass, npass2, lid);
		
		request.setAttribute( Mess, message );
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
	

}
