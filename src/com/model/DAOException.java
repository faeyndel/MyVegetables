package com.model;

/**
 * DAOException will return a message error when using model 
 * @author team MyVegetable
 * @version 1.0
 * 
 */

public class DAOException extends RuntimeException {
	  /*
     * Constructeurs
     */
    public DAOException( String message ) {
        super( message );
    }

    public DAOException( String message, Throwable cause ) {
        super( message, cause );
    }

    public DAOException( Throwable cause ) {
        super( cause );
    }
}
