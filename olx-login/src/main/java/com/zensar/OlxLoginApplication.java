package com.zensar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class OlxLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(OlxLoginApplication.class, args);
    }

}
