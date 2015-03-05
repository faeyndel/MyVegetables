package com.model;

import java.util.List;

import com.object.Commentaire;
//import com.model.DAOException;


/**
 * CommentDao give a representation of the comment model.
 * This class will list all the method needed for CommentDaoImpl.
 * We will define all the method without implementing them.
 * @author team MyVegetable
 * @version 1.0
 * 
 */
public interface CommentDao {
	/**
	 * CommentDao add a comment in the database
	 * @param mark
	 * @param pseudo
	 * @param email
	 * @param comment
	 * @param code
	 * @return confirmation message (succeed or fail)
	 */

	public String addComment(int mark, String pseudo, String email, String comment, int code);
	
	/**
	 * The lister function will get a list of all comments linked to a restaurant using the restaurant id
	 * @param id
	 * @return  comments list
	 */
	public List <Commentaire> lister(int id ) ;
}
