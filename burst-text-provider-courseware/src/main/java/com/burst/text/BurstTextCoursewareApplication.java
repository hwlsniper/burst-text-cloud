package com.burst.text;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.burst.text.mapper")
public class BurstTextCoursewareApplication {

    public static void main(String[] args) {
        SpringApplication.run(BurstTextCoursewareApplication.class, args);
    }

    /**
     * 读取静态文件配置,需要重写这个方法.否则配置文件中的值无法读取得到
     * 例如： service 中的 @Value("${headIcon}")
     *
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        PropertySourcesPlaceholderConfigurer c = new PropertySourcesPlaceholderConfigurer();
        c.setIgnoreUnresolvablePlaceholders(true);
        return c;
    }
}
