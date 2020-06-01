package Errors;

public class ErrorBean {
    private static final String DEFAULT_MESSAGE = "Exeption in service";
    
    String message;
    
    public String getMessage(){
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public static ErrorBean defaultInstance() {
        ErrorBean fault = new ErrorBean();
        fault.message = DEFAULT_MESSAGE;
        return fault;
    }
}
