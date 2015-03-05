package com.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.model.DAOUtilitaire.*;

import java.io.UnsupportedEncodingException;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * ContactDaoImpl implement ContactDao method
 * @author team MyVegetable
 * @version 1.0
 * 
 */
public class ContactDaoImpl implements ContactDao {
	
	private DAOFactory daofactory;
	
	/**
	 * Request that will insert a mail request in the database
	 */
	private static final String SQL_INSERT_contact_form = "INSERT INTO mv_contact( nickname, email, content) values (?,?,?)";
	
	 ContactDaoImpl(DAOFactory daofactory) {
		 this.daofactory=daofactory;
	 }
	
	public boolean sendMail(String Sender, String Pseudo, String Subject, String MailContent, final String Reciever, final String password, final String Charset, final String ContentType) throws UnsupportedEncodingException{
		
		boolean status = false;
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
 
		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication()                                {
				  return new PasswordAuthentication(Reciever, password);
				}
			});

		try {
 
			MimeMessage  message = new MimeMessage(session);
			message.setFrom(new InternetAddress(Sender));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(Reciever));
			message.setSubject(Subject);
			message.setContent(new String(MailContent.getBytes(), Charset), ContentType);

			Transport.send(message);
			
			Connection connexion = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;
	        String req1=SQL_INSERT_contact_form;
	        
	        try {
	        	connexion = daofactory.getConnection();
				preparedStatement = initialisationRequetePreparee( connexion,req1, false, Pseudo, Sender, MailContent); 
			    preparedStatement.executeUpdate(); 
	   	        preparedStatement.close();
				status = true;
				
			} catch (SQLException e) {
				status = false;
				throw new DAOException( e );			
			}
	        finally {
	            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	        } 
		} catch (MessagingException e) {
			status = false;	
		}
		return status;
	}
}
