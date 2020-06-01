/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Errors;

import javax.ws.rs.core.Response; 
import javax.ws.rs.core.Response.Status; 
import javax.ws.rs.ext.ExceptionMapper; 
import javax.ws.rs.ext.Provider; 
 
@Provider 
public class BadFormatExceptionMapper implements ExceptionMapper<BadFormatException> { 
 
    @Override 
    public Response toResponse(BadFormatException e) { 
        return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();   
    }  
} 

