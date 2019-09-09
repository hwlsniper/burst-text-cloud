package com.burst.text.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class AliyunConfig {
    @Value("${aliyun.ak}")
    private String ak;

    @Value("${aliyun.sk}")
    private String sk;

    @Value("${aliyun.oss.endpoint}")
    private String endpoint;

    @Value("${aliyun.oss.bucket}")
    private String bucket;

    @Value("${aliyun.oss.domain}")
    private String domain;
}
