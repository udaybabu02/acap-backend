package com.acap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Collections;

@SpringBootApplication
public class AcapApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(AcapApplication.class);
        
       
        app.setDefaultProperties(Collections.singletonMap("server.port", "8090"));
        
        app.run(args);
    }
}