package com.stefanini.handlers;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class RuntimeHandler implements ExceptionMapper<RuntimeException> {
    @Override
    public Response toResponse(RuntimeException e) {
        return Response
                .status(Response.Status.BAD_REQUEST)
                .header("Content-Type", MediaType.TEXT_PLAIN)
                .entity(e.getMessage())
                .build();
    }
}