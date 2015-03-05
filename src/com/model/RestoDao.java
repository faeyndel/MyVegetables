/**
 * RestoDao est la classe qui représente le modèle de restaurant.
 * C'est à dire une classe avec un ensemble de méthodes appliquées 
 * aux restaurants 
 * Dans cette classe, on defintit toutes les méthodes sans les implémentées
 * @author team MyVegetable
 * @version 1.0
 * 
 */package com.model;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;


import com.object.Resto_Profil;
import com.object.Resto_Photo;

/**
 * RestoDao is class giving the representation of a restaurant
 * It have a group of method for restaurant.
 * In this class we define all the method that shall be implemented. 
 * @author team MyVegetable
 * @version 1.0
 * 
 */


public interface RestoDao {
	/**
	 * This function give to a restaurant user the ability to add a restaurant.
	 * It will return a confirmation message.
	 * @param idUser
	 * @param nom
	 * @param adresse
	 * @param ville
	 * @param codepostale
	 * @param tel
	 * @param courriel
	 * @param des
	 * @param horaire
	 * @param prix
	 * @param url
	 * @param siren
	 * @param menu
	 * @param Latitude
	 * @param Longitude
	 * @return message de confirmation
	 */
	String ajout_resto(int idUser, String nom,String adresse,String ville,int codepostale,String tel,String courriel,String des,String horaire,int prix,String url,String siren, String menu, String Latitude, String Longitude);
	
	/**
	 * Convert an integer idUser in String idUser after a form submit 
	 * @param idUser (int)
	 * @return  idUser (String)
	 */
	String addRestoForm(int idUser);
	/**
	 * This function will update a restaurant informations
	 * @param nom
	 * @param adresse
	 * @param ville
	 * @param codepostale
	 * @param tel
	 * @param courriel
	 * @param des
	 * @param horaire
	 * @param prix
	 * @param url
	 * @param siren
	 * @param menu
	 * @param lattitude
	 * @param longitude
	 * @param lid
	 * @return  confirmation message
	 */
	String update_resto(String nom,String adresse,String ville,int codepostale,String tel,String courriel,String des,String horaire,int prix,String url,String siren, String menu, String lattitude, String longitude,int lid );
	
	/**
	 * Get a list of restaurant
	 * @return List of restaurants
	 */
	List <Resto_Profil> listeresto();
	
	/**
	 * Get the list of restaurants belonging to a restaurant user
	 * @param id
	 * @return List of restaurants
	 * @throws DAOException
	 */
	List <Resto_Profil> listerestoUser(int id) throws DAOException;
	
	/**
	 * Update restaurant informations of a restaurant belongign to a restaurant user
	 * @param id
	 * @return 
	 * @throws DAOException
	 */
	Resto_Profil editer(int id ) throws DAOException;
	/**
	 * Search for a restaurant using different parameters
	 * @param restoName
	 * @param restoAdress
	 * @param restoCityZip
	 * @return List of restaurant
	 * @throws DAOException
	 */
	List <Resto_Profil> search( String restoName, String restoAdress, String restoCityZip) throws DAOException;
	
	
	/**
	 * Return pictures of a restaurant using restaurant id
	 * @param lid
	 * @return an object of photo URL list
	 * @throws DAOException
	 */
	Resto_Photo getPhoto(int lid) throws DAOException;
	
    /**
     * Insert a picture URL in the database 
     * @return confirmation message
     */
	String insertPhoto( );
	
	/**
	 * Get restaurants informations and translate it in JSON format 
	 * @return List of restaurants in JSON format
	 * @throws DAOException
	 * @throws JSONException
	 */
	JSONObject listRestoJson ( ) throws DAOException, JSONException ;
	
	/**
	 * Get restaurant informations linked to a restaurant user account using his id. 
	 * @param code
	 * @return Restaurant informations
	 * @throws DAOException
	 */
	Resto_Profil restoProfil(int code ) throws DAOException;
	
}
