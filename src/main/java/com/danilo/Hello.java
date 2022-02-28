package com.danilo;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
@Stateless
public class Hello {
    
    @GET
    public String hello() {
        return "Hello, World!";
    }

}
