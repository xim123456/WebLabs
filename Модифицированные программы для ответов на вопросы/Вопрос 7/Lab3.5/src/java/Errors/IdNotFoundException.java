package Errors;

import javax.xml.ws.WebFault;

@WebFault(faultBean = "Errors.ErrorBean")
public class IdNotFoundException extends Exception {
    private static final long serialVersionUID = -6647544772732631047L; 
    private final ErrorBean fault; 
    
    public IdNotFoundException(String message, ErrorBean fault) { 
        super(message); 
        this.fault = fault; 
    } 
 
    public IdNotFoundException(String message, ErrorBean fault, Throwable cause) { 
        super(message, cause); 
        this.fault = fault; 
    } 
 
    public ErrorBean getFaultInfo() { 
        return fault; 
    } 
}

