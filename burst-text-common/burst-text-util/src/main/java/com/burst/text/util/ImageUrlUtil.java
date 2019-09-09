package com.burst.text.util;

import org.apache.commons.lang3.StringUtils;

public class ImageUrlUtil {

    private static final String HOST_URL = "http://192.168.0.124:80/";

    public String ossAcademyPath(String bucketName) {
        StringBuffer buffer = new StringBuffer();

        //SysProperties properties = SysProperties.getInstance();
        //环境： env为dev即开发环境，test即测试环境，work即正式环境
        String env = "work";//properties.getProperty("env");
        String alioss = "shenzhen";//properties.getProperty("alioss");
        String bucketServer = "headerImages";//properties.getProperty(bucketName);
        if (StringUtils.isBlank(bucketServer)) {
            return null;
        }
        buffer.append("https://");
        if (!env.equals("work") && !StringUtils.isBlank(env)) {
            bucketName += "-" + env;
        }
        buffer.append(bucketName);
        buffer.append(alioss);
        return buffer.toString();
    }

    /**
     * 阿里云上的路径补全方法
     *
     * @param resPath
     * @param w
     * @return
     */
    public String getThumbnailUrl(String resPath, Integer w) {
        if (StringUtils.isBlank(resPath)) {
            return "";
        }
        StringBuffer buffer = new StringBuffer();
        if (!resPath.startsWith("http") && !resPath.startsWith("https")) {
            String aliBucket = StringUtils.substring(resPath, 0, resPath.indexOf("/"));
            String bucketServer = ossAcademyPath(aliBucket);
            if (StringUtils.isBlank(bucketServer)) {
                return resPath;
            } else {
                buffer.append(bucketServer);
            }
        }
        buffer.append(resPath);
        //设置文件全路径
        if (w == null || w == 0) {
            return buffer.toString();
        }

        //读取配置文件
        //SysProperties properties = SysProperties.getInstance();
        //环境： env为dev即开发环境，test即测试环境，work即正式环境
        String aliThumb = "?x-oss-process=image/resize,w_${w},limit_0";//properties.getProperty("aliThumb");

        buffer.append(putWidth(aliThumb, w));
        return buffer.toString();
    }

    private String putWidth(String thumbnailUrl, Integer width) {
        if (StringUtils.isBlank(thumbnailUrl)) {
            return "";
        }
        if (width == null || width == 0) {
            return thumbnailUrl;
        }
        String contentStr = thumbnailUrl.replace("${w}", width.toString());
        return contentStr;
    }

    /**
     * 图片路径补全方法
     *
     * @param resPath
     * @return
     */
    public static String getThumbnailUrl(String resPath) {
        return HOST_URL + resPath;
    }
}
