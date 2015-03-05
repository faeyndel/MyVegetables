package com.object;

/**
 * Resto_Profil represent vegetarian restaurants
 * @author Team MyVegetable
 * @version 1.0
 */


public class Resto_Profil {
	
	/**
	 * restaurant Id
	 */
	private int  id_resto;
	/**
	 *  restaurant user id
	 */
	private int  id_resto_account;	
	
	/**
	 * Restaurant Name
	 */
	private String nom; 
	
	/**
	 * restaurant address
	 */
	private  String adresse;
	
	/**
	 * restaurant city
	 */
	private String  ville;
	
	/**
	 * Restaurant city code
	 */
	private int   code_postal; 
	
	/**
	 * restaurant phone number
	 */
	private  String telephone;
	
	/**
	 * restaurant latitude data
	 */
    private String lattitude;
    
    /**
     * restaurant time sheet
     */
    private String horaire; 
    
    /**
     * restaurant longitude data
     */
	private String  longitude; 
	
	/**
	 * restaurant url
	 */
	private String  url;
	
	/**
	 * restaurant email
	 */
	private String  courriel;
	
	/**
	 * restaurant description
	 */
	private String description;
	
	/**
	 * restaurant slogan
	 */
	private String  slogan; 
	
	/**
	 *  restaurant marks
	 */
	private int  note; 
	
	/**
	 * restaurant average price
	 */
	private int average_price;
	
	/**
	 * restaurant activate / deactivate
	 */
    private boolean  annule;
    
    /**
     * restaurant SIREN number
     */
    private String siren ;
    
    /**
     *   restaurant Menu
     */
    private String menu ;
    
    /**
     * restaurant pictures
     */
    private String photo;
    
    
    
    // Les Setters  
    
    /**
     * Get picture url
     * @return picture url
     */
    public String getPhoto() {
		return photo;
	}
    
    /**
     * Set picture url
     * @param photo
     */
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	/**
	 * Get restaurant id
	 * @return  restaurant id
	 */
	public int getId_resto_account() {
		return id_resto_account;
	}
	
	/**
	 * Set restaurant id
	 * @param id_resto_account
	 */
	public void setId_resto_account(int id_resto_account) {
		this.id_resto_account = id_resto_account;
	}
    
	
	/**
	 * Get restaurant SIREN number
	 * @return  siren
	 */
    
    public String getSiren() {
		return siren;
	}
    
    /**
     * Set siren number
     * @param siren
     */
	public void setSiren(String siren) {
		this.siren = siren;
	}
	
	/**
	 * Get restaurant time sheet
	 * @return horaire
	 */
	
	public String getHoraire() {
		return horaire;
	}
	
	/**
	 * Set restaurant time sheet
	 * @param time sheet
	 */
	public void setHoraire(String horaire) {
		this.horaire = horaire;
	}
    
	/**
	 * Get restaurant email	
	 * @return  email
	 */
	
    
    public String getCourriel() {
		return courriel;
	}
    
    /**
     * Set restaurant email
     * @param courriel
     */
	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}
	
	/**
	 * Get restaurant id
	 * @return  id_resto
	 */
	
	public int getId_resto() {
		return id_resto;
	}
	
	/**
	 * Set restaurant id
	 * @param id_resto
	 */
	public void setId_resto(int id_resto) {
		this.id_resto = id_resto;
	}
	
	/**
	 * Get restaurant name 
	 * @return  name
	 */
	
	public String getNom() {
		return nom;
	}
	
	/**
	 * Set restaurant name
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	/**
	 * Get restaurant address
	 * @return  address
	 */
	
	public String getAdresse() {
		return adresse;
	}
	
	/**
	 * Set restaurant address
	 * @param address
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
	/**
	 * Get restaurant city
	 * @return  city
	 */
	
	public String getVille() {
		return ville;
	}
	
	/**
	 * Set restaurant  city
	 * @param city
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	
	/**
	 * Get restaurant zip code 
	 * @return zip code
	 */
	
	public int getCode_postal() {
		return code_postal;
	}
	
	/**
	 * Set restaurant zip code
	 * @param code_postal
	 */
	public void setCode_postal(int code_postal) {
		this.code_postal = code_postal;
	}
	
	
	/**
	 * Get restaurant phone number
	 * @return  phone number
	 */
	
	public String getTelephone() {
		return telephone;
	}
	
	/**
	 * Set restaurant phone number
	 * @param telephone
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
	/**
	 * Get restaurant latitude 
	 * @return   latitude 
	 */
	
	public String getLattitude() {
		return lattitude;
	}
	
	/**
	 * Set restaurant latitude 
	 * @param lattitude
	 */
	public void setLattitude(String lattitude) {
		this.lattitude = lattitude;
	}
	
	
	/**
	 *  Get restaurant longitude
	 * @return   longitude
	 */
	
	public String getLongitude() {
		return longitude;
	}
	
	/**
	 * Set restaurant longitude
	 * @param longitude
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	
	
	/**
	 * Get restaurant url
	 * @return  url 
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * Set restaurant url
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	/**
	 * Get restaurant description
	 * @return  description
	 */
	
	public String getDescription() {
		return description;
	}
	
	/**
	 * Set restaurant description
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Get restaurant slogan
	 * @return slogan
	 */
	
	public String getSlogan() {
		return slogan;
	}
	
	/**
	 * Set restaurant slogan
	 * @param slogan
	 */
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	
	/**
	 * Get restaurant menu
	 * @return  menus
	 */
	
	public String getMenu() {
		return menu;
	}
	
	/**
	 * Set restaurant menu
	 * @param menu
	 */
	public void setMenu(String menu) {
		this.menu = menu;
	}
	
	
	/**
	 * Get restaurant average mark
	 * @return
	 */
	
	public int getNote() {
		return note;
	}
	
	/**
	 * Set restaurant average mark
	 * @param note
	 */
	public void setNote(int note) {
		this.note = note;
	}
	
	
	/**
	 * Get restaurant average price
	 * @return  average_price
	 */
	
	public int getAverage_price() {
		return average_price;
	}
	
	/**
	 * Set restaurant average_price 
	 * @param average_price
	 */
	public void setAverage_price(int average_price) {
		this.average_price = average_price;
	}
	
	
	/**
	 *  Get Activate / Deactivate restaurant status
	 * @return
	 */
	
	public boolean isAnnule() {
		return annule;
	}
	
	/**
	 * Set Activate / Deactivate restaurant status
	 * @param annule
	 */
	public void setAnnule(boolean annule) {
		this.annule = annule;
	}  

}
