package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.DAOFactory;
import com.model.ContactDao;

// Cette servlet permet d'envoyer un mail 
public class SendingMail  extends HttpServlet{
	    
		private static final long serialVersionUID = 1L;
		
		public static final String CONF_DAO_FACTORY 	= "daofactory";
		public static final String VUE1         		= "/contact.jsp";
	    public static final String VUE2          		= "/exeptionsendmail.jsp";
	    public static final String Mess         		= "erreur";
	    public static final String MessageConfirmation 	= "message";
		private final 		String Reciever 			= "myvegeta81es@gmail.com";
		private final 		String password 			= "mestablesvegetariennes";
		private final 		String Charset 				= "UTF-8";
		private final 		String ContentType 			= "text/plain";
	    
		private ContactDao      contactDao;

	    public void init() throws ServletException {
	        /* R�cup�ration d'une instance de notre DAO Resto */
	        this.contactDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getContactDao();
	    }
		
		
	    public void doPost(   HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
	    	
	    	response.setCharacterEncoding("UTF-8");
	    	request.setCharacterEncoding("UTF-8");
	    	
	    	
	    	
	    	
	    	
	    	String messageConfirmation="";
	    	String MessageErreur= "Votre message n'a pu été envoyé ,veuillez réitérer<br>"+
	    	                      "Votre envoie";
	    	
	        String  Sender	= 	request.getParameter("email");
	        String	Pseudo 	=  	request.getParameter("pseudo");
	        String 	Content	= 	request.getParameter("suggestion");
	        String 	Subject	=	" Vous avez recu un message de ";
	        Subject+=Pseudo;
	        String	MailContent = "/************************** Contact **************************/\r\n\r\n"+
	        						Sender+"\r\n\r\n/************************** Content **************************/\r\n\r\n"+
	        						Content;
	        boolean succeed = this.contactDao.sendMail(Sender, Pseudo, Subject, MailContent, Reciever, password, Charset, ContentType);
	        
	        if(succeed == true){
	        	messageConfirmation = "Votre message a bien été transmis <br>";
				messageConfirmation+=" Merci de nous avoir contacté ! Nous vous répondrons dans les plus brefs délais <br>  "+
				                     "L'équipe MyVegetable <br>";
				
				request.setAttribute( MessageConfirmation, messageConfirmation );
		        this.getServletContext().getRequestDispatcher( VUE1 ).forward( request, response );	
			}else{
				request.setAttribute( Mess,MessageErreur );
		        this.getServletContext().getRequestDispatcher( VUE2 ).forward( request, response );
			}
	        
	          
	    	
			
	    }
		
	
	

}
