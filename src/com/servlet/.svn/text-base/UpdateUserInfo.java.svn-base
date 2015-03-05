package com.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.*;
import com.object.Resto_Account;
import com.object.User;

public class UpdateUserInfo extends HttpServlet {
	
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
    	
    	User user = new User();
    	//HttpSession session= request.getSession();
    	
    	//String  idUserS=request.getParameter("comptei");
    	//int lid = Integer.parseInt(idUserS.trim());
    	HttpSession session = request.getSession(false);
    	int  lid= (Integer) session.getAttribute("userId");
		String phone=  request.getParameter("tel");
		String courriel= request.getParameter("email");	
		String message=this.userDao.update_user(phone, courriel, lid);
		user= (User) session.getAttribute("objet");
		user.setPhone(phone);
		user.setEmail(courriel);
		session.setAttribute("objet",user);
		request.setAttribute( Mess, message );
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
	

}
