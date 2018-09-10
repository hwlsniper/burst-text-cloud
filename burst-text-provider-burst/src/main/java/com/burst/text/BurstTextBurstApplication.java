package com.burst.text;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Administrator
 */
@EnableEurekaClient
@SpringBootApplication
//@ComponentScan(value={"com.burst.text.mapper","com.burst.text.web", "com.burst.text.service", "com.burst.text.core"})
@MapperScan(basePackages="com.burst.text.mapper")
public class BurstTextBurstApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(BurstTextBurstApplication.class, args);
    }
}
