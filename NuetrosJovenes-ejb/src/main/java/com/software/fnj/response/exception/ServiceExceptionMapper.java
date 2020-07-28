/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.response.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author santiago
 */
@Provider
public class ServiceExceptionMapper implements ExceptionMapper<ServiceException>{

    @Override
    public Response toResponse(ServiceException exception) {
        ServiceError error = new ServiceError();
        error.setErrorMessage(exception.getMessage());
        error.setErrorCode(exception.getStatusCode());
        StringWriter witter = new StringWriter();
        exception.printStackTrace(new PrintWriter(witter));
        
        return Response.status(exception.getStatusCode()).entity(error).type(MediaType.APPLICATION_JSON).build();
    }
    
}
