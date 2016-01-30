package com.unitn.adapter_service;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath(MyApplicationConfig.APPLICATION_PATH)
public class MyApplicationConfig extends ResourceConfig {

    static final String APPLICATION_PATH = "adapter_service";
    static final int PORT = 5700;

    public MyApplicationConfig () {
        packages("com.unitn.adapter_service");

//        register(LoggingFilter.class);
        register(ExceptionListener.class);

    }
}
