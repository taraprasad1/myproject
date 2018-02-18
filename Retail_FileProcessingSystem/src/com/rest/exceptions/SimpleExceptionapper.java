package com.rest.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.rest.models.Message;
@Provider
public class SimpleExceptionapper implements ExceptionMapper<SimpleException> {

	@Override
	public Response toResponse(SimpleException arg0) {
		// TODO Auto-generated method stub
		Message message=new Message(404,arg0.getMessage(),"google.com");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(message).build();
	}

}
