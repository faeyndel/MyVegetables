package com.model;

import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.object.Commentaire;
import static com.model.DAOUtilitaire.*;

import com.model.DAOException;

//import com.foed.dao.OffreDao;


/**
 * CommentDaoImpl implement CommentDao method.
 * @author team MyVegetable
 * @version 1.0
 * 
 */
public class CommentDaoImpl implements CommentDao {
	
	private DAOFactory daofactory;
	private static final String SQL_INSERT_Comment = "INSERT INTO mv_commentaires ( id_resto, nickname, commentaire, date_commentaire, note, email)	values (?,?,?,NOW(),?,?)";
	private static final String SQL_SELECT_Comment_By_Id = "Select * FROM mv_commentaires" +
			                                               " WHERE id_resto= ? AND annule= 0 "+
			                                               " ORDER BY note DESC ";

     CommentDaoImpl(DAOFactory daofactory) {
 		this.daofactory=daofactory;
 	   }

     public String addComment(int mark, String pseudo, String email, String comment, int code){
    	String message="";
 		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        //String str1 = "àéïô..."; 
        String str2 = new String(comment.getBytes(),Charset.forName("UTF-8"));
        comment = str2;
        //System.out.println(comment);

         String req1=SQL_INSERT_Comment;
         
         try {
 			connexion = daofactory.getConnection();
 			preparedStatement = initialisationRequetePreparee( connexion,req1, false, code, pseudo, comment, mark, email);
 		    //resultSet = preparedStatement.executeQuery(); 
 		    preparedStatement.executeUpdate(); 
    	    preparedStatement.close();
 		    message="Votre commentaire a été ajouté.";
 		    
 		} catch (SQLException e) {
 			
 			throw new DAOException( e );			
 		}
         finally {
             fermeturesSilencieuses( resultSet, preparedStatement, connexion );
         }       
         
       
 		return message;
     }
	 
     
     
     
     public List <Commentaire> lister(int id ) throws DAOException {

    	 Connection connexion = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;
	        Commentaire commentaire = null;
	        List<Commentaire> commentaires = new ArrayList<Commentaire>(); 
	        
	        try {
	            /* R�cup�ration d'une connexion depuis la Factory */
	            connexion = daofactory.getConnection();
	            preparedStatement = initialisationRequetePreparee( connexion, SQL_SELECT_Comment_By_Id, false,id);
	            resultSet = preparedStatement.executeQuery();
	            while( resultSet.next() )
	            	
	            {        	
	            	
	            	commentaire = map( resultSet );	            	
	            	//restos.add(tempuser); 
	            	commentaires.add(commentaire);
	               
	            }	            
	        } catch ( SQLException e ) {
	            throw new DAOException( e );
	     	}finally {
	            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	        }
		 return commentaires;
     }

	/**
	 * This method get all data's from comment table and will return a comment object 
	 * @param resultSet
	 * @return comment object
	 * @throws SQLException
	 */
     
     private static Commentaire  map( ResultSet resultSet ) throws SQLException {
    	    Commentaire res = new Commentaire();
	    	res.setCommentaire(resultSet.getString( "commentaire" ));
	    	res.setDate_comment(resultSet.getDate("date_commentaire"));
	    	res.setNickname(resultSet.getString("nickname"));
	    	res.setNote(resultSet.getInt("note"));
	        return res ;
	    } 

	   
}