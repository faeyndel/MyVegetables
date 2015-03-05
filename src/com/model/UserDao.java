package com.model;


import com.object.Resto_Account;
import com.object.User;
import com.model.DAOException;

/**
 * UserDao is a class that represent a user model.
 * It's a group of method for users.
 * In this class we define all the method needed without implementing them. 
 * @author team MyVegetable
 * @version 1.0
 * 
 */

public interface UserDao {

	//List<User> lister( ) throws DAOException;
	/**
	 * This function will add  informations about a classic user
	 * @param Nom
	 * @param Prenom
	 * @param login
	 * @param phone
	 * @param password
	 * @param email
	 * @return confirmation message
	 */
	String addUser(String Nom, String Prenom, String login, String phone, String password, String email);
	/**
	 * Add informations about a restaurant user
	 * @param Nom
	 * @param Prenom
	 * @param login
	 * @param phone
	 * @param password
	 * @param email
	 * @return  confirmation message
	 */
	String addUserResto(String Nom, String Prenom, String login, String phone, String password, String email);
	
	/**
	 * Update informations about a classic user
	 * @param id
	 * @return confirmation message
	 * @throws DAOException
	 */
	
	User editer(int id ) throws DAOException;
	
	/**
	 * Update informations about a restaurant user
	 * @param id
	 * @return confirmation message
	 * @throws DAOException
	 */
	User editerResto(int id ) throws DAOException;
	
	/**
	 * Update phone number and email of a classic user
	 * @param phone
	 * @param email
	 * @param lid
	 * @return confirmation message
	 */
	
	String update_user(String phone, String email, int lid );
	
	/**
	 * Update password of a classic user 
	 * @param oldpassword
	 * @param password
	 * @param password2
	 * @param lid
	 * @return
	 */
	String update_user_pw(String oldpassword, String password, String password2, int lid );
	
	/**
	 * Update the phone number and email of a restaurant user
	 * @param phone
	 * @param email
	 * @param lid
	 * @return confirmation message
	 */
	
	String update_user_resto(String phone, String email, int lid );
	
	/**
	 * Update password of a restaurant user
	 * @param oldpassword
	 * @param password
	 * @param password2
	 * @param lid
	 * @return confirmation message
	 */
	String update_user_resto_pw(String oldpassword, String password, String password2, int lid );
	
	
	/**
	 * Check password of a classic user
	 * @param login
	 * @param password
	 * @return User object
	 */
	User verifUser(String login,String password);	
	
	/**
	 * Check password of a restaurant user
	 * @param login
	 * @param password
	 * @return Restaurant user object (resto_account)
	 */
	Resto_Account  verifaccountResto (String login,String password);
	
	
	/**
	 * Deactivate a user account 
	 * @param compte
	 * @param lid
	 * @return confirmation message
	 */	
	String unsubscribe(String compte, int lid);
}
