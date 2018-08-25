package com.burst.text;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Administrator
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class BurstTextUserApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(BurstTextUserApplication.class, args);
    }
}
