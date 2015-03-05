package com.object;


/**
 * Resto_Photo represent all the restaurant pictures 
 * @author Team MyVegetable
 * @version 1.0
 */

public class Resto_Photo {
	
	/**
	 * restaurant photos id
	 */
	private int id_resto_photo;
	
	/**
	 * restaurant id
	 */
	private int id_resto;
	
	/**
	 * restaurant url slider picture
	 */
	private String photo_slider;
	
	/**
	 * restaurant url avatar picture
	 */
	private String photo_annuaire;
	
	/**
	 * restaurant url partner
	 */
	private String photo_partenaire;
	
	/* Setter */
	
	/**
	 * Set restaurant picture id
	 * @param id_resto_photo
	 */
	public void setId_resto_photo( int id_resto_photo ){
		this.id_resto_photo = id_resto_photo;
	}
	
	/**
	 * Set restaurant id
	 * @param id_resto
	 */
	public void setId_resto( int id_resto ){
		this.id_resto = id_resto;
	}
	
	/**
	 * Set restaurant url slider picture
	 * @param photo_slider
	 */
	public void setPhoto_slider( String photo_slider ){
		this.photo_slider = photo_slider;
	}
	
	/**
	 * Set restaurant url avatar picture
	 * @param photo_annuaire
	 */
	public void setPhoto_annuaire( String photo_annuaire ){
		this.photo_annuaire = photo_annuaire;
	}
	
	/**
	 * Set restaurant url partner picture
	 * @param photo_partenaire
	 */
	public void setPhoto_partenaire( String photo_partenaire ){
		this.photo_partenaire = photo_partenaire;
	}
	
	/* Getter */
    /**
     * Get restaurant picture id
     * @return  id_resto_photo
     */
	int getId_resto_photo(  ){
		return id_resto_photo;
	}
	
	/**
     * Get restaurant Id
     * @return id_resto
     */
	public int getId_resto(   ){
		return id_resto;
	}
	
	/**
     * Get restaurant url slider picture
     * @return  photo_slider
     */
	public String getPhoto_slider(   ){
		return photo_slider;
	}
	
	/**
     * Get restaurant url avatar picture
     * @return  photo_annuaire
     */
	public String getPhoto_annuaire(   ){
		return photo_annuaire;
	}
	
	/**
     * get restaurant url partner picture
     * @return  photo_partenaire
     */
	public String getPhoto_partenaire(   ){
		return  photo_partenaire;
	}
}
