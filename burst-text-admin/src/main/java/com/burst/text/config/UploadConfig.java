package com.burst.text.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class UploadConfig {

    /**
     * 基础配置
     */
    //文件上传方式
    @Value("${upload.config.up-type}")
    private String upType;

    //图片访问地址
    @Value("${upload.config.up-cdn}")
    private String upCdn;

    //单个文件上传大小，单位为M
    @Value("${upload.config.max-file-size}")
    private Integer maxFileSize;
    /**
     * 路径
     */
    //保存硬盘地址
    @Value("${upload.config.hard-disk}")
    private String hardDisk;
    //默认图片类型文件夹
    @Value("${upload.config.image-folder}")
    private String imageFolder;
    //默认文件类型文件夹
    @Value("${upload.config.document-folder}")
    private String documentFolder;
    //默认的视频类型文件夹
    @Value("${upload.config.video-folder}")
    private String videoFolder;
    //默认的音频类型文件夹
    @Value("${upload.config.music-folder}")
    private String musicFolder;
    //允许上传的ip(上传白名单)

    /**
     * 类型
     */
    //图片类型
    @Value("${upload.config.image-type}")
    private String[] imageType;
    //文件类型
    @Value("${upload.config.document-type}")
    private String[] documentType;
    //视频类型
    @Value("${upload.config.video-type}")
    private String[] videoType;
    //音频类型
    @Value("${upload.config.music-type}")
    private String[] musicType;
}
