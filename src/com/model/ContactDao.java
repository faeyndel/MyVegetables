package com.model;

import java.io.UnsupportedEncodingException;

/**
 * ContactDao is a class that will represent the contact model.
 * It will define all the method needed for the contact form and will implement them. 
 * @author team MyVegetable
 * @version 1.0
 * 
 */


public interface ContactDao {
	/**
	 * This method send a mail and return a boolean that will let us know
	 * if the function have succeeded or failed
	 * @param Sender
	 * @param Pseudo
	 * @param Subject
	 * @param MailContent
	 * @param Reciever
	 * @param password
	 * @param Charset
	 * @param ContentType
	 * @return confirmation message
	 * @throws UnsupportedEncodingException
	 */
	public boolean sendMail(String Sender, String Pseudo, String Subject, String MailContent, final String Reciever, final String password, final String Charset, final String ContentType) throws UnsupportedEncodingException;
}
