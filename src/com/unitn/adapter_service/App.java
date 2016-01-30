package com.unitn.adapter_service;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;

public class App {
    public static void main(String[] args) throws IllegalArgumentException, IOException, URISyntaxException {
        String protocol = "http://";
        String port_value = Integer.toString(MyApplicationConfig.PORT);
        if (String.valueOf(System.getenv("PORT")) != "null") {
            port_value = String.valueOf(System.getenv("PORT"));
            System.out.println("PORT ENV IS "+port_value);
        }

        String hostname = InetAddress.getLocalHost().getHostAddress();
        if (hostname.equals("127.0.0.1")) {
            hostname = "localhost";
        }

        URI BASE_URI = new URI(protocol +
                hostname + ":" +
                port_value + "/" +
                MyApplicationConfig.APPLICATION_PATH);

        System.out.println("Starting AdapterService standalone HTTP server...");
        JdkHttpServerFactory.createHttpServer(BASE_URI, createApp());
        System.out.println("Server started on " + BASE_URI + "\n[kill the process to exit]");
    }

    public static ResourceConfig createApp() {
        System.out.println("Starting adapterService...");
        return new MyApplicationConfig();
    }
}
