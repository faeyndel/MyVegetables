package com.object;


/**
 * Resto_Account class define restaurant user account 
 * @author Team MyVegetable
 * @version 1.0
 */

// Classe des Comptes-restaurants

public class Resto_Account {
	
	/**
	 * restaurant user account id	
	 */
	private int id_resto_account;
	
	/**
	 * restaurant user account login
	 */
	private String login;
	
	/**
	 * restaurant user account email
	 */
	private String email;
	
	/**
	 * restaurant user account password
	 */
	private String password;
	
	/**
	 * restaurant user account Last name
	 */
	private String Nom;
	
	/**
	 *  restaurant user account First name
	 */
	private String Prenom;
	
	/**
	 * restaurant user account phone number
	 */
	private String phone;
	
	/**
	 * Get restaurant user account Last name
	 * @return  nom
	 */
	
	public String getNom() {
		return Nom;
	}
	
	/**
	 * Set restaurant user account Last name
	 * @param nom
	 */
	public void setNom(String nom) {
		Nom = nom;
	}
	
	
	/**
	 * Get restaurant user account First name
	 * @return  prenom
	 */
	
	public String getPrenom() {
		return Prenom;
	}
	
	/**
	 * Set restaurant user account first name
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	
	
	
	/**
	 * Get restaurant user account phone number
	 * @return phone
	 */
	
	public String getPhone() {
		return phone;
	}
	
	/**
	 * Set restaurant user account phone number
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	/**
	 * Get restaurant user account id
	 * @return  l'id du restaurateur
	 */
	
	public int getId_resto_account() {
		return id_resto_account;
	}
	
	/**
	 * Set restaurant user account id
	 * @param id_resto_account
	 */
	public void setId_resto_account(int id_resto_account) {
		this.id_resto_account = id_resto_account;
	}
	
	
	/**
	 * Get restaurant user account login 
	 * @return  login
	 */
	
	
	public String getLogin() {
		return login;
	}
	
	/**
	 * Set restaurant user account login
	 * @param login
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	
	
	/**
	 * Get restaurant user account email
	 * @return  email
	 */
	
	public String getEmail() {
		return email;
	}
	
	/**
	 * Set restaurant user account email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	/**
	 * Get restaurant user account password
	 * @return	 */
	
	public String getPassword() {
		return password;
	}
	
	/**
	 * Set restaurant user account password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
