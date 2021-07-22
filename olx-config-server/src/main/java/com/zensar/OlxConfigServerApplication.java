package com.zensar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class OlxConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OlxConfigServerApplication.class, args);
    }

}
