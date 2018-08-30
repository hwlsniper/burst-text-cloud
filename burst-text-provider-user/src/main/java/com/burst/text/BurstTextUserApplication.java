package com.burst.text;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @author Administrator
 *
 */
@MapperScan("com.burst.text.mapper")
@SpringBootApplication
@EnableEurekaClient
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class BurstTextUserApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(BurstTextUserApplication.class, args);
    }

    @Bean
    public DruidDataSource getDataSource(){
        return new DruidDataSource();
    }
}
