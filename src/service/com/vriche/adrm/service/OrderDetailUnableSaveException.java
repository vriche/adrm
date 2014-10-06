package com.vriche.adrm.service;


/**
 * An exception that is thrown by classes wanting to trap unique 
 * constraint violations.  This is used to wrap Spring's 
 * DataIntegrityViolationException so it's checked in the web layer.
 *
 * <p><a href="UserExistsException.java.html"><i>View Source</i></a></p>
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class OrderDetailUnableSaveException extends Exception {
	  
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 5606960831405604806L;

	/**
     * Constructor for UserExistsException.
     *
     * @param message
     */
    public OrderDetailUnableSaveException(String message) {
        super(message);
    }
}
