package com.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.security.MessageDigest;

import com.object.Resto_Account;
import com.object.User;
//import com.object.Result_User;
import static com.model.DAOUtilitaire.*;

import com.model.DAOException;

//import com.foed.dao.OffreDao;

/**
 * UserDaoImpl implement RestoDao class
 * @author team MyVegetable
 * @version 1.0
 * 
 */


public class UserDaoImpl implements UserDao
{
   
	private DAOFactory daofactory;
	//private static final String SQL_SELECT_Users = "SELECT id_user,login,pseudo,email FROM mv_users";
	// requete de selection d'un utilisateur de compte particulier ayant un login et mot de passe 
	private static final String SQL_SELECT_User_By_Login_Pwd = "SELECT * FROM mv_users Where login= ? AND password = ? AND annule = 0";
	// requete de selection un utilisateur de compte de type restaurant ayant un login et mot de passe
	private static final String SQL_SELECT_Account__By_Login_Pwd = "SELECT * FROM mv_resto_account Where login= ? AND password = ?";
	// requete d'ajout d'un utilisateur de compte particulier
	private static final String SQL_INSERT_User_Private_Account = "INSERT INTO mv_users( Nom, Prenom, login, phone, password, email)	values (?,?,?,?,MD5(?),?)";
	// requete d'ajout d'un utilisateur de compte restaurant
	private static final String SQL_INSERT_User_Resto_Account = "INSERT INTO mv_resto_account( Nom, Prenom, login, phone, email, password)	values (?,?,?,?,?,MD5(?))";
    // requete de selection des informations d'un utilisateur de compte particulier
	private static final String SQL_SELECT_User_Info_by_Id = "SELECT id_user, Nom, Prenom, login, phone, email FROM mv_users WHERE id_user=?";
	// requete de selection des informations d'un utilisateur de compte restaurant
	private static final String SQL_SELECT_User_Resto_Info_by_Id = "SELECT id_resto_account, Nom, Prenom, login, phone, email FROM mv_resto_account WHERE id_resto_account=?";
    
	
	// requete de  mise à jour du numero de telephone et d'email pour nun utilisateur de compte particulier	
	private static final String SQL_SELECT_Update_User_Info_by_Id = "UPDATE mv_users SET phone=?, email=? WHERE id_user=?";
	// requete de  mise à jour du numero de telephone et d'email pour nun utilisateur de compte restaurant
	private static final String SQL_SELECT_Update_User_Resto_Info_by_Id = "UPDATE mv_resto_account SET phone=?, email=? WHERE id_resto_account=?";
	// requete de  mise à jour du mot de passe  pour nun utilisateur de compte particulier
	private static final String SQL_SELECT_Update_User_PW_by_Id = "UPDATE mv_users SET password=MD5(?) WHERE id_user=?";
	// requete de  mise à jour du mot de passe  pour nun utilisateur de compte restaurant
	private static final String SQL_SELECT_Update_User_Resto_PW_by_Id = "UPDATE mv_resto_account SET password=MD5(?) WHERE id_resto_account=?";
	// recupération d'un login et mot de passe d'un utilisateur de compte particulier
	private static final String SQL_SELECT_Get_Pw_by_Id = "SELECT id_user, password FROM mv_users WHERE  id_user=? AND password=?";
	// recupération d'un login et mot de passe d'un utilisateur de compte restaurant
	private static final String SQL_SELECT_Get_Pw_Resto_by_Id = "SELECT id_resto_account, password FROM mv_resto_account WHERE id_resto_account=? AND password=?";
	// desactiver le compte d'un utilisateur de type particulier
	private static final String SQL_SELECT_Delete_User_by_Id = "UPDATE mv_users SET annule=1 WHERE id_user=?";
	// desactiver le compte d'un utilisateur de type restaurant
	private static final String SQL_SELECT_Delete_User_Resto_by_Id = "UPDATE mv_resto_account SET annule=1 WHERE id_resto_account=?";
	//desactivation d'un restautants d'un utilisateur de compte particulier
	private static final String SQL_SELECT_Delete_Resto_by_Id = "UPDATE mv_resto_profile SET annule=1 WHERE id_resto=?";
	//desactivation d'un restautant d'un utilisateur de compte restaurant
	private static final String SQL_SELECT_Delete_Resto_by_Id_User = "UPDATE mv_resto_profile SET annule=1 WHERE id_resto_account=?";
    // recupération des informations d'un utilisateur de compte particulier selon un login ou un email
	private static final String SQL_CHECK_LOG_PW_USER = "SELECT * FROM mv_users WHERE login=? OR email=?";
	// recupération des informations d'un utilisateur de compte restaurant selon un login ou un email
	private static final String SQL_CHECK_LOG_PW_RESTO = "SELECT * FROM mv_resto_account WHERE login=? OR email=?";
	
    UserDaoImpl(DAOFactory daofactory) {
		this.daofactory=daofactory;
	   }
    
    /**
     * Function that Crypt a (String) password in MD5 
     * @param md5
     * @return password in MD5
     */
    public static String MD5(String md5) {
		   try {
		        MessageDigest md =MessageDigest.getInstance("MD5");
		        byte[] array = md.digest(md5.getBytes());
		        StringBuffer sb = new StringBuffer();
		        for (int i = 0; i < array.length; ++i) {
		          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
		       }
		        return sb.toString();
		    } catch (java.security.NoSuchAlgorithmException e) {
		    }
		    return null;
		}
    
    // desactivation d'un utilisateur 
    public String unsubscribe(String compte, int lid){
    	String message="";
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user=null;

        String req1=SQL_SELECT_Delete_User_by_Id;
        String req2=SQL_SELECT_Delete_User_Resto_by_Id;
        String req3=SQL_SELECT_Delete_Resto_by_Id;
        String req4=SQL_SELECT_Delete_Resto_by_Id_User;
        
        try {
			connexion = daofactory.getConnection();
			if(compte.compareTo("userAccount") == 0){
				preparedStatement = initialisationRequetePreparee( connexion,req1, false, lid);
				preparedStatement.executeUpdate(); 
	   	        preparedStatement.close();
			    message="Votre compte utilisateur a été supprimé.";
				
			}else if (compte.compareTo("restoAccount") == 0){
				preparedStatement = initialisationRequetePreparee( connexion,req2, false, lid);
				preparedStatement.executeUpdate();
				preparedStatement = initialisationRequetePreparee( connexion,req4, false, lid);
				preparedStatement.executeUpdate(); 
	   	        preparedStatement.close();
			    message="Votre compte restaurateur ainsi que leurs restaurants ont été supprimé.";
			    
			}else if (compte.compareTo("resto") == 0){
				preparedStatement = initialisationRequetePreparee( connexion,req3, false, lid);
				preparedStatement.executeUpdate(); 
	   	        preparedStatement.close();
			    message="Votre restaurant a été supprimé.";
			}
			
		} catch (SQLException e) {
			
			throw new DAOException( e );			
		}
        finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        } 

		return message;
    }
    

    public String update_user_resto_pw(String oldpassword, String password, String password2, int lid ) {
		
		String message="";
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user=null;

        oldpassword = MD5(oldpassword);

        String req1=SQL_SELECT_Update_User_Resto_PW_by_Id;
        String req2=SQL_SELECT_Get_Pw_Resto_by_Id;
        
        try {
			connexion = daofactory.getConnection();
			preparedStatement = initialisationRequetePreparee( connexion,req2, false, lid, oldpassword);
		    resultSet = preparedStatement.executeQuery(); 

		    if ( resultSet.next() == true){

		    	if(password.compareTo(password2) == 0){

	         		try {
		    			
		    			preparedStatement = initialisationRequetePreparee( connexion,req1, false, password, lid);
		    		    preparedStatement.executeUpdate(); 
		       	        preparedStatement.close();
		    		    message="Votre nouveau mot de passe a été enregistré.";

		    		} catch (SQLException e) {
		    			
		    			throw new DAOException( e );			
		    		}
	         	}else{
	         		message="Mot de passe différent.";
	         	}

	          }else{
	        	  message="Mot de passe incorrect.";
	          }
		} catch (SQLException e) {
			
			throw new DAOException( e );			
		}
        finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        } 

		return message;
	}
    
    
    public String update_user_pw(String oldpassword, String password, String password2, int lid ) {
		
		String message="";
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user=null;

        oldpassword = MD5(oldpassword);

        String req1=SQL_SELECT_Update_User_PW_by_Id;
        String req2=SQL_SELECT_Get_Pw_by_Id;
        
        try {
			connexion = daofactory.getConnection();
			preparedStatement = initialisationRequetePreparee( connexion,req2, false, lid, oldpassword);
		    resultSet = preparedStatement.executeQuery(); 

		    if ( resultSet.next() == true){

		    	if(password.compareTo(password2) == 0){

	         		try {
		    			
		    			preparedStatement = initialisationRequetePreparee( connexion,req1, false, password, lid);
		    		    preparedStatement.executeUpdate(); 
		       	        preparedStatement.close();
		    		    message="Votre nouveau mot de passe a été enregistré.";

		    		} catch (SQLException e) {
		    			
		    			throw new DAOException( e );			
		    		}
	         	}else{
	         		message="Mot de passe différent.";
	         	}

	          }else{
	        	  message="Mot de passe incorrect.";
	          }
		} catch (SQLException e) {
			
			throw new DAOException( e );			
		}
        finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        } 

		return message;
	}
    
   
    public String update_user(String phone, String email, int lid ) {
		
		String message="";
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //Resto_Profil resto;

        String req1=SQL_SELECT_Update_User_Info_by_Id;
        
        try {
			connexion = daofactory.getConnection();
			preparedStatement = initialisationRequetePreparee( connexion,req1, false, phone, email, lid);
		    //resultSet = preparedStatement.executeQuery(); 
		    preparedStatement.executeUpdate(); 
   	        preparedStatement.close();
		    message="Vos informations ont été enregistrées.";
		    
		} catch (SQLException e) {
			
			throw new DAOException( e );			
		}
        finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }       
        
      
		return message;
	}
    
    public String update_user_resto(String phone, String email, int lid ) {
		
		String message="";
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //Resto_Profil resto;
        String req1=SQL_SELECT_Update_User_Resto_Info_by_Id;
        
        try {
			connexion = daofactory.getConnection();
			preparedStatement = initialisationRequetePreparee( connexion,req1, false, phone, email, lid);
		    //resultSet = preparedStatement.executeQuery(); 
		    preparedStatement.executeUpdate(); 
   	        preparedStatement.close();
		    message="Vos informations ont été  enregistrées.";
		    
		} catch (SQLException e) {
			
			throw new DAOException( e );			
		}
        finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }       
        
      
		return message;
	}
    
    public User editerResto(int code ) throws DAOException {

		//String req1;
    	Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User tempuser = null;
               
        try {
            /* R�cup�ration d'une connexion depuis la Factory */
            connexion = daofactory.getConnection();
            
            preparedStatement = initialisationRequetePreparee( connexion,SQL_SELECT_User_Resto_Info_by_Id, false,code);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next())         
            {
              tempuser = map3( resultSet );
            }
            else 
            {
            	System.out.println("Aucun résultat trouvé dans la table");
            }
                               
            } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }
        
        return  tempuser;		
				
		}
    
    
    
    public User editer(int code ) throws DAOException {

    	Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User tempuser = null;
               
        try {
            /* R�cup�ration d'une connexion depuis la Factory */
            connexion = daofactory.getConnection();
            
            preparedStatement = initialisationRequetePreparee( connexion,SQL_SELECT_User_Info_by_Id, false,code);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next())         
            {
              tempuser = map( resultSet );
            }
            else 
            {
            	System.out.println("Aucun résultat trouvé dans la table");
            }
                               
            } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }
        return  tempuser;		
				
		}
    
    
	public String addUser(String Nom, String Prenom, String login, String phone, String password, String email){
		
		String message="";
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean valid = false;
        String req1=SQL_INSERT_User_Private_Account;
        String req2=SQL_CHECK_LOG_PW_USER;

        try {
			connexion = daofactory.getConnection();
			preparedStatement = initialisationRequetePreparee( connexion,req2, false,login,email);
		    resultSet = preparedStatement.executeQuery(); 
   	        
   	     if ( resultSet.next() == false){
   	    	valid = true;     	         
          }else{
        	  message="";
          }
		} catch (SQLException e) {
			throw new DAOException( e );			
		}
        finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }  
        
        if(valid == true){
	        try {
				connexion = daofactory.getConnection();
				preparedStatement = initialisationRequetePreparee( connexion,req1, false,Nom, Prenom, login, phone, password ,email);
			    preparedStatement.executeUpdate(); 
	   	        preparedStatement.close();
			    message="Votre compte a bien été créer.";
			    
			} catch (SQLException e) {
				
				throw new DAOException( e );			
			}
	        finally {
	            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	        }       
        }
      
		return message;
	}
    
	
	
	
	public String addUserResto(String Nom, String Prenom, String login, String phone, String password, String email){
		
		String message="";
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String req1=SQL_INSERT_User_Resto_Account;
        String req2=SQL_CHECK_LOG_PW_RESTO;
        boolean valid = false;

        try {
			connexion = daofactory.getConnection();
			preparedStatement = initialisationRequetePreparee( connexion,req2, false,login,email);
		    resultSet = preparedStatement.executeQuery(); 
   	        
   	     if ( resultSet.next() == false){
   	    	valid = true;     	         
          }else{
        	  message="";
          }
		} catch (SQLException e) {
			throw new DAOException( e );			
		}
        finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }  
        
        if(valid == true){
	        try {
				connexion = daofactory.getConnection();
				preparedStatement = initialisationRequetePreparee( connexion,req1, false,Nom, Prenom, login, phone, email, password);
			    preparedStatement.executeUpdate(); 
	   	        preparedStatement.close();
			    message="Votre compte a bien été créer.";
			    
			} catch (SQLException e) {
				
				throw new DAOException( e );			
			}
	        finally {
	            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	        }       
        }
      
		return message;
	}
	
	
	public User verifUser(String login,String password)
	{
		
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user=null;
       
        String req1=SQL_SELECT_User_By_Login_Pwd;
        
         
        // cryptage de mon password en md5
        String pwd = MD5(password);
        
          
        

	        try {
				connexion = daofactory.getConnection();
				preparedStatement = initialisationRequetePreparee( connexion,req1, false,login,pwd);
			    resultSet = preparedStatement.executeQuery(); 
	   	     if ( resultSet.next()){
	         	user = map(resultSet);        	
	         	          
	          }
			    
			} catch (SQLException e) {
				
				throw new DAOException( e );			
			}
	        finally {
	            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	        }       

		return user;  
	}
	
	
	
	
	
	public Resto_Account  verifaccountResto (String login,String password)
	{
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Resto_Account user=null;
        String req1=SQL_SELECT_Account__By_Login_Pwd;
        String pwd = MD5(password);
        
        try {
			connexion = daofactory.getConnection();
			preparedStatement = initialisationRequetePreparee( connexion,req1, false,login,pwd);
		    resultSet = preparedStatement.executeQuery(); 
		    //preparedStatement.executeUpdate(); 
   	        //preparedStatement.close();
   	        
   	     if ( resultSet.next()){
         	user = map2(resultSet);        	
         	          
          }
		   
		    
		} catch (SQLException e) {
			
			throw new DAOException( e );			
		}
        finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }       
        
		
		return user;  
		
	}
    
  
   	
	 /**
     * Method making the mapping between the user table and a bean user
     */
    private static User map( ResultSet resultSet ) throws SQLException {
        User us = new User();
        us.setId_user( resultSet.getInt( "id_user" ) );
        us.setNom_user( resultSet.getString( "Nom" ) );
        us.setPrenom_user( resultSet.getString( "Prenom" ) );
        us.setLogin( resultSet.getString( "login" ) );
        us.setPhone( resultSet.getString( "phone" ) );
        us.setEmail( resultSet.getString( "email" ) );     
        return us;
    }   
    
    
    private static Resto_Account map2( ResultSet resultSet ) throws SQLException {
    	Resto_Account us = new Resto_Account();
    	us.setId_resto_account( resultSet.getInt( "id_resto_account" ));
        us.setNom( resultSet.getString( "Nom" ) );
        us.setPrenom( resultSet.getString( "Prenom" ) );
        us.setLogin( resultSet.getString( "login" ) );        
        us.setEmail( resultSet.getString( "email" ) );
        us.setPhone(resultSet.getString( "phone" ));
        return us;
    }  
    
    private static User map3( ResultSet resultSet ) throws SQLException {
    	User us = new User();
    	us.setId_resto_account( resultSet.getInt( "id_resto_account" ));
        us.setNom_user( resultSet.getString( "Nom" ) );
        us.setPrenom_user( resultSet.getString( "Prenom" ) );
        us.setLogin( resultSet.getString( "login" ) );        
        us.setEmail( resultSet.getString( "email" ) );     
        us.setPhone( resultSet.getString( "phone" ) );
        return us;
    }
    
    
    
   
 

}
