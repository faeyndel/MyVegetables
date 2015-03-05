package com.object;

import java.util.Date;

/**
 * Commentaire define user comments 
 * @author team MyVegetable
 * @version 1.0
 * 
 */

public class Commentaire {
	
	/**
	 * Comments id
	 */
	private int id_comment;
	
	/**
	 * User id
	 */
	private int id_user;
	
	/**
	 *  Comments content
	 */
	private String commentaire;
	
	/**
	 * Comments title
	 */
	private String titre_comment;
	
	/**
	 * Publish Date of Comments
	 */
	private Date  date_comment;
	
	/**
	 *  User nickname
	 */
	private String nickname;
	
	/**
	 * Comments mark
	 */
	private int note;
	
	/**
	 * Comments Activated / Deactivated status
	 */
	private boolean annule;
	
	/* Setter */
	
	/**
	 * Set Comment id
	 * @param id_comment
	 */
	public void setId_comment( int id_comment ){
		this.id_comment = id_comment;
	}
	
	/**
	 * Set user id
	 * @param id_user
	 */
	public void setId_user( int id_user ){
		this.id_user = id_user;
	}
	
	/**
	 * Set Comment mark
	 * @param note
	 */
	public void setNote( int note ){
		this.note = note;
	}
	
	/**
	 * Set nickname
	 * @param nickname
	 */
	public void setNickname( String nickname ){
		this.nickname = nickname;
	}
	
	/**
	 * Set Comment
	 * @param commentaire
	 */
	public void setCommentaire( String commentaire ){
		this.commentaire = commentaire;
	}
	
	/**
	 * Set Comment title
	 * @param titre_comment
	 */
	public void setTitre_comment( String titre_comment ){
		this.titre_comment = titre_comment;
	}
	
	/**
	 * Set Comment publish date
	 * @param date_comment
	 */
	public void setDate_comment( Date date_comment ){
		this.date_comment = date_comment;
	}
	
	/**
	 * Set Activate / Deactivate status
	 * @param annule
	 */
	public void setAnnule( boolean annule ){
		this.annule = annule;
	}
	
	/* Getter */
	
	/**
	 * Get Comment id
	 * @return id_comment
	 */
	public int getId_comment(){
		return id_comment;
	}
	
	/**
	 * Get  User id
	 * @return id_user
	 */
	public int getId_user(){
		return id_user;
	}
	
	/**
	 * Get  nickname
	 * @return nickname
	 */
	public String getNickname(){
		return nickname;
	}
	
	/**
	 * Get Comment mark
	 * @return note
	 */
	public int getNote(){
		return note;
	}
	
	/**
	 * Get Comment
	 * @return  Comments
	 */
	public String getCommentaire(){
		return commentaire;
	}
	
	/**
	 * Get Comment title
	 * @return  title_comment
	 */
	public String getTitre_comment(){
		return  titre_comment;
	}
	
	/**
	 * Get Publish date of Comment
	 * @return date_comment
	 */
	public Date getDate_comment(){
		return date_comment;
	}
	
	/**
	 * Get Activate / Deactivate status
	 * @return  annule 
	 */
	public boolean setAnnule(){
		return annule;
	}
	
	
}
