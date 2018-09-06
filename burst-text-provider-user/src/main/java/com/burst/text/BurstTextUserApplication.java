package com.burst.text;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Administrator
 *
 */
@SpringBootApplication
@EnableEurekaClient
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@MapperScan("com.burst.text.mapper")
public class BurstTextUserApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(BurstTextUserApplication.class, args);
    }

    /**@Bean
    public DruidDataSource getDataSource(){
        return new DruidDataSource();
    }*/
}
