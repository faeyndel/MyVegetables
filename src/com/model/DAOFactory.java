package com.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DAOFactory is the class mapping for our database object
 * @author team MyVegetable
 * @version 1.0
 * 
 */

public class DAOFactory {   
    
    /**
     * URL to connect to the database
     */
    private String              url;
    /**
     * Login to connect to the database
     */
    private String              username;
    /**
     * Password to connect to the database
     */
    private String              password;
    //private String              encode;
    //private String				jdbc;
    

    DAOFactory( String url, String username, String password, String jdbc, String jdbcutf8) {
    	this.url = url;
        this.username = username;
        this.password = password;    	
    }

   
    /**
     * Method that shall fetch connection informations of the database, load JDBC Driver
     * and return an new instance of Factory
     * @return  instance of mapping class 
     * @throws DAOConfigurationException
     */
    public static DAOFactory getInstance() throws DAOConfigurationException {
       // Properties properties = new Properties();
        String url = "//localhost/myvegetable";
        String driver="com.mysql.jdbc.Driver";
        //String nomUtilisateur="root";
        //String motDePasse="";
        //String nomUtilisateur="root_superviseur";
        //String motDePasse="admin";

        String nomUtilisateur="myvege";
        String motDePasse="nBHR8be5YVc2xdwh";
        
        String jdbc = "jdbc:mysql:"+url+"?user="+nomUtilisateur+"&password="+motDePasse;
        String jdbcutf8 = "&useUnicode=true&characterEncoding=UTF-8";
        
        try {
            Class.forName( driver );
        } catch ( ClassNotFoundException e ) {
            throw new DAOConfigurationException( "Le driver est introuvable dans le classpath.", e );
        }

        DAOFactory instance = new DAOFactory( url, nomUtilisateur, motDePasse, jdbc, jdbcutf8 );
        return instance;
    }

    
    /**
     * Method that give a connection to the database
     * @return
     * @throws SQLException
     */
    Connection getConnection() throws SQLException {
        return DriverManager.getConnection( "jdbc:mysql:" + url, username, password );
        //return DriverManager.getConnection( jdbc+encode );
     }    
   
    

    /**
     * Get user model
     * @return user model 
     */
    public UserDao getUserDao() {
        return new UserDaoImpl( this );
    }
    
    /**
     * Get restaurant model
     * @return restaurant model
     */
   
    public RestoDao getRestoDao() {
        return new RestoDaoImpl( this );
    } 
    
    /**
     * Get comments model
     * @return comments model
     */
    
    public CommentDao getCommentDao() {
        return new CommentDaoImpl( this );
    }
    
    
    /**
     * Get contact model
     * @return  contact model
     */
    public ContactDaoImpl getContactDao() {
        return new ContactDaoImpl( this );
    }
}