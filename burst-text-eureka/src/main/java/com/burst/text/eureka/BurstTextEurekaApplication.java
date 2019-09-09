package com.burst.text.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Administrator
 */
@SpringBootApplication
@EnableEurekaServer
public class BurstTextEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(BurstTextEurekaApplication.class, args);
    }
}
