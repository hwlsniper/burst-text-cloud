package com.burst.text;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("io.swagger.mybatis.dao")
@SpringBootApplication
// @EnableSwagger2
@EnableAutoConfiguration
// @ComponentScan(basePackages = "io.swagger")
public class BurstTextMapperApplication {

    public static void main(String[] args){
        SpringApplication.run(BurstTextMapperApplication.class, args);
    }
}
