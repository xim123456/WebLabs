package Errors;

import javax.xml.ws.WebFault;

@WebFault(faultBean = "Errors.ThrottlingException")
public class ThrottlingException extends Exception {
    private static final long serialVersionUID = -6647544772732631046L; 
    private final ErrorBean fault; 
    
    public ThrottlingException(String message, ErrorBean fault) { 
        super(message); 
        this.fault = fault; 
    } 
 
    public ThrottlingException(String message, ErrorBean fault, Throwable cause) { 
        super(message, cause); 
        this.fault = fault; 
    } 

    public ErrorBean getFaultInfo() { 
        return fault; 
    } 
}
