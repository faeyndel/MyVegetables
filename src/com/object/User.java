package com.object;


/**
 * User will represent all the users (classic and restaurant)
 * @author Team MyVegetable
 * @version 1.0
 */



public class User {
	
	/**
	 *  Classic user id
	 */
	private int id_user;
	
	/**
	 * Restaurant user id 
	 */
	private int id_resto_account;
	
	/**
	 * User Last name
	 */
	private String Nom;
	
	/**
	 * User First name
	 */
	private String Prenom;
	
	/**
	 * User login
	 */
	private String login;
	
	/**
	 * User phone number
	 */
	private String phone;
	
	/**
	 * User password
	 */
	private String password;
	
	/**
	 * User email
	 */
	private String email;
	
	/**
	 * Number of comments
	 */
	private int nb_commentaire;
	
	/**
	 * Activate / deactivate the user account
	 */
	private boolean annule;
	
	
	
	/* Setter */
	/**
	 * Set classic user id
	 * @param id_user
	 */
	
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	
	/**
	 * Set restaurant user id 
	 * @param id_resto_account
	 */
	public void setId_resto_account(int id_resto_account) {
		this.id_resto_account = id_resto_account;
	}
	
	/**
	 * Set user Last name
	 * @param Nom
	 */
	public void setNom_user(String Nom){
		this.Nom = Nom;
	}
	
	/**
	 * Set user First name
	 * @param Prenom
	 */
	public void setPrenom_user(String Prenom){
		this.Prenom = Prenom;
	}
	
	/**
	 * Set user login 
	 * @param login
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	
	/**
	 * Set user phone number
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * Set user password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Set user email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Set number of comments
	 * @param nb_commentaire
	 */
	public void setNb_commentaire(int nb_commentaire) {
		this.nb_commentaire = nb_commentaire;
	}
	
	/**
	 * Set activate / deactivate userM account
	 * @param annule
	 */
	public void setAnnule(boolean annule) {
		this.annule = annule;
	}
	
	
	/* Getter */
	
	/**
	 * Get classic user id
	 * @return  classic user id
	 */
	
	public int getId_user() {
		return id_user;
	}
	
	/**
	 * Get restaurant user id
	 * @return  restaurant user id
	 */
	public int getId_resto_account() {
		return id_resto_account;
	}
	
	/**
	 * Get user Last Name
	 * @return  user Last Name
	 */
	public String getNom() {
		return Nom;
	}
	
	/**
	 * Get user First Name
	 * @return  user First Name
	 */
	public String getPrenom() {
		return Prenom;
	}
	
	/**
	 * Get user login
	 * @return  login 
	 */
	public String getLogin() {
		return login;
	}
	
	/**
	 * Get user password
	 * @return  password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Get phone number
	 * @return  phone number
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * Get email
	 * @return  email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * retourne le nombre de commentaire  de l'utilisateur
	 * @return  le nombre de commentaire
	 */
	public int  getNb_commentaire() {
		return nb_commentaire;
	}
	
	/**
	 * retourne le booleen d'activation ou de desactivation  de l'utilisateur
	 * @return
	 */
	public boolean isAnnule() {
		return annule;
	}
	
}
