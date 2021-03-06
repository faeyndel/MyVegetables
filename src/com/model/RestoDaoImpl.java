
package com.model;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;


import com.model.DAOException;
import com.object.Resto_Profil;
import com.object.Resto_Photo;


import static com.model.DAOUtilitaire.*;

/**
 * RestoDaoImpl implement RestoDao class
 * @author team MyVegetable
 * @version 1.0
 * 
 */

public class RestoDaoImpl implements RestoDao {
	
	 private DAOFactory daofactory;
	
	 // requete d'insertion d'un restaurant
     private static final String SQL_Insert_Resto_Profil = "INSERT INTO mv_resto_profile(id_resto_account, nom, adresse, ville,code_postal,telephone,email, lattitude, longitude, url,description,horaires, front_menu, average_price,siren,annule)"+
                                                           "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?,0)";
     
     // requete de récupération d'un restaurant selon l'id 
     private static final String SQL_Get_Resto_Id = "SELECT * FROM mv_resto_profile WHERE id_resto_account=? AND nom=?";
     
     // ajout des photos dans la table resto_photo
     private static final String SQL_Init_Resto_Photo = "INSERT INTO mv_resto_photos(id_resto) VALUES (?)";
     
     //recupération de la liste de restaurant actifs
     private static final String SQL_SELECT_Resto = "SELECT * FROM mv_resto_profile WHERE annule = 0 ";
     // récupération des photos d'un restaurant
     private static final String SQL_SELECT_Photo_By_ID_Resto = "SELECT * FROM mv_resto_photos As p,mv_resto_profile As rp" +
     		"                                                     WHERE p.id_resto = ? ";
     // requete de selection de la liste de restaurant selon un id 
     private static final String SQL_SELECT_List_Resto_By_User_Id = "SELECT * FROM mv_resto_profile WHERE annule = 0 AND id_resto_account=?";
     
     
     // requete de selection d'un restaurant selon l'id passé en paramètre
     private static final String SQL_SELECT_Resto_By_Id= "SELECT * FROM mv_resto_profile WHERE id_resto=? AND annule=0";
     
     
     //requete de mise à jour des informations d'un restaurant
     private static final String SQL_Update_Resto_Profil = "UPDATE mv_resto_profile "+
                                                            "SET nom = ?, "+"adresse = ?,"+ "ville = ?," + "code_postal = ?," + "telephone = ?, " +
    		                                                "email = ?," + "url = ?,"+ "description = ?,"+ "horaires = ?,"+"average_price = ?,"+
                                                            "siren= ?,"+"front_menu= ?,"+"lattitude= ?,"+"longitude= ?"+"WHERE id_resto = ?";
                                                            
     // requete de recupération des photos d'un restaurant
     private static final String SQL_SELECT_Photo_Resto_By_Id= "SELECT * FROM mv_resto_photos WHERE id_resto=?";
     
     
     
     RestoDaoImpl(DAOFactory daofactory) {
 		this.daofactory=daofactory;
 	   }
     
     
     /**
      * Get user Id
      */

	public String addRestoForm(int idUser){
		return String.valueOf(idUser) ;
	}
	
	/**
	 * Insert a photo
	 */
     
	public String insertPhoto(){
		String message="";
		return message;
	}
	
	
	/**
	 * Get photo object using restaurant id given in parameter  
	 */
	public Resto_Photo getPhoto(int lid) throws DAOException{
    	Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Resto_Photo tempresto = null;
               
        try {
            /* Récupération  d'une connexion depuis la Factory */
            connexion = daofactory.getConnection();
            
            preparedStatement = initialisationRequetePreparee( connexion,SQL_SELECT_Photo_Resto_By_Id, false,lid);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next())         
            {

              tempresto = mapPhoto( resultSet );
              tempresto.setId_resto(lid);

            }else{
            	tempresto = mapPhotoInt( lid );
            }

                               
            } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }
        

        return  tempresto;		
	}
	/**
	 * Function that search for a restaurant
	 */
	
	public List <Resto_Profil> search( String restoName, String restoAdress, String restoCityZip)  throws DAOException {
		Connection connexion2 = null;
        PreparedStatement preparedStatement2 = null;
        ResultSet resultSet2 = null;
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Resto_Profil resto = null;
        List<Resto_Profil> restos=new ArrayList<Resto_Profil>();
        String reqToPerform = "";

        if (restoName != ""){
        	reqToPerform += "(SELECT * FROM mv_resto_profile WHERE nom LIKE ? AND annule=0)";
        }
        if(restoAdress != ""){
        	if (restoName != ""){
        		reqToPerform += " UNION ";
        	}
        	reqToPerform += "(SELECT * FROM mv_resto_profile WHERE adresse LIKE ? AND annule=0)";
        }
        if(restoCityZip != ""){
        	if (restoName != "" || restoAdress != ""){
        		reqToPerform += " UNION ";
        	}
        	reqToPerform += "(SELECT * FROM mv_resto_profile WHERE ville LIKE ? AND annule=0)";
        }
        
        reqToPerform += " ORDER BY nom ";
        
        
        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daofactory.getConnection();
            
            if (restoName != "" && restoAdress != "" && restoCityZip != ""){
            	preparedStatement = initialisationRequetePreparee( connexion, reqToPerform, false, "%"+restoName+"%", "%"+restoAdress+"%", "%"+restoCityZip+"%");
            }else if(restoAdress != "" && restoCityZip != ""){
            	preparedStatement = initialisationRequetePreparee( connexion, reqToPerform, false, "%"+restoAdress+"%", "%"+restoCityZip+"%");
            }else if(restoName != "" && restoCityZip != ""){
           	 	preparedStatement = initialisationRequetePreparee( connexion, reqToPerform, false, "%"+restoName+"%", "%"+restoCityZip+"%");
            }else if(restoName != "" && restoAdress != ""){
              	preparedStatement = initialisationRequetePreparee( connexion, reqToPerform, false, "%"+restoName+"%", "%"+restoAdress+"%");
            }else if(restoName != ""){
             	preparedStatement = initialisationRequetePreparee( connexion, reqToPerform, false, "%"+restoName+"%");
            }else if(restoAdress != ""){
           	 	preparedStatement = initialisationRequetePreparee( connexion, reqToPerform, false, "%"+restoAdress+"%");
            }else if(restoCityZip != ""){
            	preparedStatement = initialisationRequetePreparee( connexion, reqToPerform, false, "%"+restoCityZip+"%");
            }

            resultSet = preparedStatement.executeQuery();

            while( resultSet.next() )
            	
            {        	
            	resto=new Resto_Profil();
            	resto = map( resultSet );
            	
            	try {
           		 connexion2 = daofactory.getConnection();
   	            preparedStatement2 = initialisationRequetePreparee( connexion2, SQL_SELECT_Photo_By_ID_Resto, false,resto.getId_resto());
   	            resultSet2 = preparedStatement2.executeQuery();
   	            if ( resultSet2.next() )
   	            	
   	            {        	
   	            	
   	            	resto.setPhoto(resultSet2.getString("photo_annuaire"));
   	               
   	            }
   	            else
   	            {
   	            	resto.setPhoto("Pas de Photo");
   	            }
   	        } catch ( SQLException e ) {
   	            throw new DAOException( e );
   	     	}finally {
   	            fermeturesSilencieuses( resultSet2, preparedStatement2, connexion2 );
   	        }
           	
            	
            	restos.add(resto);
               
            }	            
        } catch ( SQLException e ) {
            throw new DAOException( e );
     	}finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }
	 return restos;
	}
     /**
      * Function that insert a restaurant in the database
      */
	public String ajout_resto(int idUser, String nom, String adresse, String ville,	int codepostale, String tel, String courriel, String des,String horaire, int prix, String url,String siren, String menu, String Latitude, String Longitude) {
		
		String message="";
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String req1=SQL_Insert_Resto_Profil;
        String req2=SQL_Get_Resto_Id;
        String req3=SQL_Init_Resto_Photo;
        
        try {
			connexion = daofactory.getConnection();
			preparedStatement = initialisationRequetePreparee( connexion,req1, false, idUser, nom, adresse, ville,codepostale,tel,courriel,Latitude, Longitude,url,des,horaire, menu,prix,siren);
			preparedStatement.executeUpdate(); 

		    preparedStatement = initialisationRequetePreparee( connexion,req2, false, idUser, nom);
		    resultSet = preparedStatement.executeQuery();
 
		    if( resultSet.next() )
            {        	
		    	Resto_Profil dataResto2 = map4(resultSet);

			    int accountRestoId = dataResto2.getId_resto();
			    preparedStatement = initialisationRequetePreparee( connexion,req3, false, accountRestoId);
			    message="Votre restaurant a été ajouté avec succés ";
            }else{
            	message="Une erreur est survenue lors de la création des information de votre restaurant. Veuillez contacter un membre de l'équipe afin de résoudre le problème.";
            }
		    
		    preparedStatement.executeUpdate(); 
   	        preparedStatement.close();
		   
		    
		} catch (SQLException e) {
			
			throw new DAOException( e );			
		}
        finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }       
        
      
		return message;
	}
	
	/**
	 *   Function that will update restaurant informations
	 */
	
	public String update_resto(String nom, String adresse, String ville,int codepostale, String tel, String courriel, String des,String horaire, int prix, String url,String siren, String menu, String lattitude, String longitude,int lid) {
		
		String message="";
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String req1=SQL_Update_Resto_Profil;
        
        try {
			connexion = daofactory.getConnection();
			preparedStatement = initialisationRequetePreparee( connexion,req1, false,nom, adresse, ville,codepostale,tel,courriel,url,des,horaire,prix,siren,menu,lattitude, longitude,lid); 
		    preparedStatement.executeUpdate(); 
   	        preparedStatement.close();
		    message="Votre restaurant a été modifié";
		    
		} catch (SQLException e) {
			
			throw new DAOException( e );			
		}
        finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }       
        
      
		return message;
	}
	
	
	/**
	 * Function that list all restaurants of a specific user 
	 */
	public List <Resto_Profil> listerestoUser ( int code )  throws DAOException 
	 {
		   Connection connexion = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;
	        Connection connexion2 = null;
	        PreparedStatement preparedStatement2 = null;
	        ResultSet resultSet2 = null;
	        Resto_Profil resto = null;
	        List<Resto_Profil> restos=new ArrayList<Resto_Profil>(); 
	        
	        try {
	            /* Récupération d'une connexion depuis la Factory */
	            connexion = daofactory.getConnection();
	            preparedStatement = initialisationRequetePreparee( connexion, SQL_SELECT_List_Resto_By_User_Id, false, code);
	            resultSet = preparedStatement.executeQuery();

	            while( resultSet.next() )
	            	
	            {        	
	            	resto=new Resto_Profil();
	            	resto = map( resultSet ); 

	            	try {
	            		 connexion2 = daofactory.getConnection();
	    	            preparedStatement2 = initialisationRequetePreparee( connexion2, SQL_SELECT_Photo_By_ID_Resto, false,resto.getId_resto());
	    	            resultSet2 = preparedStatement2.executeQuery();
	    	            if ( resultSet2.next() )
	    	            	
	    	            {        	
	    	            	
	    	            	resto.setPhoto(resultSet2.getString("photo_annuaire"));
	    	               
	    	            }
	    	            else
	    	            {
	    	            	resto.setPhoto("Pas de Photo");
	    	            }
	    	        } catch ( SQLException e ) {
	    	            throw new DAOException( e );
	    	     	}finally {
	    	            fermeturesSilencieuses( resultSet2, preparedStatement2, connexion2 );
	    	        }
	            	
	            	
	            	restos.add(resto);
	               
	            }	            
	        } catch ( SQLException e ) {
	            throw new DAOException( e );
	     	}finally {
	            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	        }
		 return restos;
		 
	 }
	
	/**
	 * Function that return a list of all restaurants 
	 */
	public List <Resto_Profil> listeresto ( ) throws DAOException
	 {
		   Connection connexion = null;
		   Connection connexion2 = null;
	        PreparedStatement preparedStatement = null;
	        PreparedStatement preparedStatement2 = null;
	        ResultSet resultSet = null;
	        ResultSet resultSet2 = null;
	        Resto_Profil resto = null;
	        List<Resto_Profil> restos=new ArrayList<Resto_Profil>(); 
	        
	        try {
	            /* Récupération d'une connexion depuis la Factory */
	            connexion = daofactory.getConnection();
	            preparedStatement = initialisationRequetePreparee( connexion, SQL_SELECT_Resto, false);
	            resultSet = preparedStatement.executeQuery();
	            while( resultSet.next() )
	            	
	            {        	
	            	resto=new Resto_Profil();
	            	resto = map( resultSet );	       
	            	
	            	
		            	try {
		            		 connexion2 = daofactory.getConnection();
		    	            preparedStatement2 = initialisationRequetePreparee( connexion2, SQL_SELECT_Photo_By_ID_Resto, false,resto.getId_resto());
		    	            resultSet2 = preparedStatement2.executeQuery();
		    	            if ( resultSet2.next() )
		    	            	
		    	            {        	
		    	            	
		    	            	resto.setPhoto(resultSet2.getString("photo_annuaire"));
		    	               
		    	            }
		    	            else
		    	            {
		    	            	resto.setPhoto("Pas de Photo");
		    	            }
		    	        } catch ( SQLException e ) {
		    	            throw new DAOException( e );
		    	     	}finally {
		    	            fermeturesSilencieuses( resultSet2, preparedStatement2, connexion2 );
		    	        }
	            	
	            	
	            	restos.add(resto);
	               
	            }	            
	        } catch ( SQLException e ) {
	            throw new DAOException( e );
	     	}finally {
	            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	        }
		 return restos;
		 
	 }
	 /**
	 * Function that get pictures path of a restaurant
	 */
	
	 public Resto_Profil restoProfil(int code ) throws DAOException {

	    	Connection connexion = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;
	        Connection connexion2 = null;
	        PreparedStatement preparedStatement2 = null;
	        ResultSet resultSet2 = null;
	        Resto_Profil tempresto = null;
	        
	               
	        try {
	            /* Récupération  d'une connexion depuis la Factory */
	            connexion = daofactory.getConnection();
	            
	            preparedStatement = initialisationRequetePreparee( connexion,SQL_SELECT_Resto_By_Id, false,code);
	            resultSet = preparedStatement.executeQuery();
	            if (resultSet.next())         
	            {
	            	tempresto=new Resto_Profil();
	              tempresto = map2( resultSet );
	              
	              try {
	            		 connexion2 = daofactory.getConnection();
	    	            preparedStatement2 = initialisationRequetePreparee( connexion2, SQL_SELECT_Photo_By_ID_Resto, false,tempresto.getId_resto());
	    	            resultSet2 = preparedStatement2.executeQuery();
	    	            if ( resultSet2.next() )
	    	            	
	    	            {        	
	    	            	
	    	            	tempresto.setPhoto(resultSet2.getString("photo_slider"));
	    	               
	    	            }
	    	            else
	    	            {
	    	            	tempresto.setPhoto("Pas de Photo");
	    	            }
	    	        } catch ( SQLException e ) {
	    	            throw new DAOException( e );
	    	     	}finally {
	    	            fermeturesSilencieuses( resultSet2, preparedStatement2, connexion2 );
	    	        }
	              
	              
	            }
	            else 
	            {
	            	System.out.println("Aucun résultat");
	            }
	                               
	            } catch ( SQLException e ) {
	            throw new DAOException( e );
	        } finally {
	            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	        }
	        
	        return  tempresto;		
					
			}
	
	
	
	/**
	 * Function that will get a restaurant informations for a coming edition
	 */
	
	 
	 public Resto_Profil editer(int code ) throws DAOException {

	    	Connection connexion = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;
	        Resto_Profil tempresto = null;
	        
	               
	        try {
	            /* Récupération  d'une connexion depuis la Factory */
	            connexion = daofactory.getConnection();
	            
	            preparedStatement = initialisationRequetePreparee( connexion,SQL_SELECT_Resto_By_Id, false,code);
	            resultSet = preparedStatement.executeQuery();
	            if (resultSet.next())         
	            {
	              tempresto = map2( resultSet );
	            }
	            else 
	            {
	            	System.out.println("Aucun résultat");
	            }
	                               
	            } catch ( SQLException e ) {
	            throw new DAOException( e );
	        } finally {
	            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	        }
	        
	        return  tempresto;		
					
			}
	 
	 
	 /**
	  *  Function that return a list of restaurants in JSON format
	  */
	 
	 public JSONObject listRestoJson ( ) throws DAOException, JSONException
	 {
		 Connection connexion = null;
		 Connection connexion2 = null;
	     PreparedStatement preparedStatement = null;
	     ResultSet resultSet = null;
	     PreparedStatement preparedStatement2 = null;
	     ResultSet resultSet2 = null;
	     List<Resto_Profil> list=new ArrayList<Resto_Profil>();
	     Resto_Profil temp;
	     JSONObject jsonObject = new JSONObject();
	     try {
	            /* Récupération  d'une connexion depuis la Factory */
	            connexion = daofactory.getConnection();	            
	            preparedStatement = initialisationRequetePreparee( connexion,SQL_SELECT_Resto, false);
	            resultSet = preparedStatement.executeQuery();

	            while (resultSet.next())         
	            {
	            	temp=new Resto_Profil();
	            	temp = map2( resultSet );

	            	
	            	try {
	    	            
	    	            connexion2 = daofactory.getConnection();
	    	            preparedStatement2 = initialisationRequetePreparee( connexion2, SQL_SELECT_Photo_By_ID_Resto, false,temp.getId_resto());
	    	            resultSet2 = preparedStatement2.executeQuery();
	    	            if ( resultSet2.next() )
	    	            	
	    	            {        	
	    	            	
	    	            	temp.setPhoto(resultSet2.getString("photo_annuaire"));
	    	               
	    	            }
	    	            else
	    	            {
	    	            	temp.setPhoto("Pas de Photo");
	    	            }
	    	        } catch ( SQLException e ) {
	    	            throw new DAOException( e );
	    	     	}finally {
	    	            fermeturesSilencieuses( resultSet2, preparedStatement2, connexion2 );
	    	        }
	            	list.add(temp);            	
	             
	            }  

            	
            	jsonObject.put("markers",list);
              
	                               
	            } catch ( SQLException e ) {
	            throw new DAOException( e );
	        } finally {
	            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	        }
	     
		  return jsonObject;
	 } 

	 
	 
	 
	 
	   /**
	     * Those method are mapping a table line of resto_profile and a resto object
	     */
	    private static Resto_Profil  map( ResultSet resultSet ) throws SQLException {
	    	Resto_Profil res = new Resto_Profil();
	    	res.setId_resto( resultSet.getInt( "id_resto" ));
	    	res .setNom(resultSet.getString( "nom" ));
	    	res .setAdresse(resultSet.getString( "adresse" ) );   	 
	    	res .setCode_postal(resultSet.getInt("code_postal"));
	    	res .setTelephone(resultSet.getString("telephone"));
	    	res.setUrl(resultSet.getString( "url" ));
	    	res.setDescription(resultSet.getString( "description" ));
	    	res.setMenu(resultSet.getString( "front_menu" ));
	    	res.setLattitude(resultSet.getString( "lattitude" ));
	    	res.setLongitude(resultSet.getString( "longitude" ));
	        return res ;
	    }
   
	    
	    private static Resto_Profil  map4( ResultSet resultSet ) throws SQLException {
	    	Resto_Profil res = new Resto_Profil();
	    	res.setId_resto( resultSet.getInt( "id_resto" ));
	        return res ;
	    }
	    
	    private static Resto_Profil  map2( ResultSet resultSet ) throws SQLException {
	    	Resto_Profil res = new Resto_Profil();
	    	res.setId_resto( resultSet.getInt( "id_resto" ));
	    	res .setNom(resultSet.getString( "nom" ));
	    	res .setAdresse(resultSet.getString( "adresse" ) );   	 
	    	res .setCode_postal(resultSet.getInt("code_postal"));
	    	res .setTelephone(resultSet.getString("telephone"));
	    	res.setUrl(resultSet.getString( "url" ));
	    	res.setDescription(resultSet.getString( "description" ));
	    	res.setLattitude(resultSet.getString( "lattitude" ));
	    	res.setLongitude(resultSet.getString( "longitude" ));
	    	res.setNote(resultSet.getInt( "note" ));
	    	res.setAverage_price(resultSet.getInt( "average_price" ));
	    	res.setCourriel(resultSet.getString("email"));
	    	res.setHoraire(resultSet.getString("horaires"));
	    	res.setVille(resultSet.getString("ville"));
	    	res.setSiren(resultSet.getString("siren"));
	    	res.setMenu(resultSet.getString( "front_menu" ));
	        return res ;
	    }   
	    
	    /**
	     * Those method will make the mapping between a table line from resto_photo
	     * and a photo object
	     */
	    
	    private static Resto_Photo mapPhoto( ResultSet resultSet ) throws SQLException {
	    	Resto_Photo res = new Resto_Photo();
	    	res.setId_resto_photo( resultSet.getInt( "id_resto_photo" ));
	    	res.setId_resto(resultSet.getInt("id_resto"));
	    	res.setPhoto_slider(resultSet.getString( "photo_slider" ));
	    	res.setPhoto_annuaire(resultSet.getString( "photo_annuaire" ) );   	 
	    	res.setPhoto_partenaire(resultSet.getString("photo_partenaire"));
	        return res ;
	    }  
	   
	    private static Resto_Photo mapPhotoInt( int resultSet ) throws SQLException {
	    	Resto_Photo res = new Resto_Photo();
	    	res.setId_resto(resultSet);
	        return res ;
	    }  
}