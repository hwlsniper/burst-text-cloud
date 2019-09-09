package com.burst.text.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * bootstrap.yml 配置文件读取不到(spring boot-1.5.18),将配置文件内容放在 application.yml 可以读取到
 */
@Data
@Component
@ConfigurationProperties("web.upload-path")
public class FilePathConfig {

    //@Value("${web.upload-path.headIcon}")
    private String headIcon;

    //@Value("${web.upload-path.posterTemp}")
    private String posterTemp;

    //@Value("${web.upload-path.rqcodeIcon}")
    private String rqcodeIcon;

    //@Value("${web.upload-path.courseFile}")
    private String courseFile;

    //@Value("${web.upload-path.courseImage}")
    private String courseImage;

    //@Value("${web.upload-path.}")
    private String burstImgs;

    //@Value("${web.upload-path.defaultPath}")
    private String defaultPath;

}
