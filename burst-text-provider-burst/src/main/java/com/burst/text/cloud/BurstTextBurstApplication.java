package com.burst.text.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Administrator
 */
@EnableEurekaClient
@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@MapperScan("com.burst.text.mapper")
public class BurstTextBurstApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(BurstTextBurstApplication.class, args);
    }
}
