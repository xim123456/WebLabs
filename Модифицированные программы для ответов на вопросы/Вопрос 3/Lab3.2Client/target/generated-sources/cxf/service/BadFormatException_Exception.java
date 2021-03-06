
package service;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.2.3
 * Wed May 27 15:29:20 MSK 2020
 * Generated source version: 2.2.3
 * 
 */

@WebFault(name = "BadFormatException", targetNamespace = "http://Service/")
public class BadFormatException_Exception extends Exception {
    public static final long serialVersionUID = 20200527152920L;
    
    private service.BadFormatException badFormatException;

    public BadFormatException_Exception() {
        super();
    }
    
    public BadFormatException_Exception(String message) {
        super(message);
    }
    
    public BadFormatException_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public BadFormatException_Exception(String message, service.BadFormatException badFormatException) {
        super(message);
        this.badFormatException = badFormatException;
    }

    public BadFormatException_Exception(String message, service.BadFormatException badFormatException, Throwable cause) {
        super(message, cause);
        this.badFormatException = badFormatException;
    }

    public service.BadFormatException getFaultInfo() {
        return this.badFormatException;
    }
}
