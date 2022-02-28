package com.danilo;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath(value = "/api")
public class Configuration extends Application {
    
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        addRestResouceClasses(resources);
        return resources;
    }

    private void addRestResouceClasses(Set<Class<?>> resources) {
        resources.add(com.danilo.Hello.class);
    }

}
