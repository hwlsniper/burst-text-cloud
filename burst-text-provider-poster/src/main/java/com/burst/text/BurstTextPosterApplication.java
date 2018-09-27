package com.burst.text;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 海报
 * @author Administrator
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages="com.burst.text.mapper")
public class BurstTextPosterApplication {

    public static void main(String[] args){
        SpringApplication.run(BurstTextPosterApplication.class, args);
    }
}
