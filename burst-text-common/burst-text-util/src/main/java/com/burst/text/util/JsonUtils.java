package com.burst.text.util;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @ClassName: JsonUtils
 * @Description:自定义响应结构
 * @author: 天刀-盛泽荣
 * @date: 2018年6月10日 下午9:41:23
 * @Copyright: 2018 www.tydic.com Inc. All rights reserved.
 * 注意：本内容仅限于***内部传阅，禁止外泄以及用于其他的商业目
 */
public class JsonUtils {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * @throws
     * @Title: objectToJson
     * @Description: 将对象转换成json字符串
     * @author: 天刀-盛泽荣
     * @date: 2018年6月10日 下午9:45:48
     * @param: @param data
     * @param: @return
     * @return: String
     */
    public static String objectToJson(Object data) {
        try {
            String string = MAPPER.writeValueAsString(data);
            return string;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @throws
     * @Title: jsonToPojo
     * @Description: 将json结果集转化为对象
     * @author: 天刀-盛泽荣
     * @date: 2018年6月10日 下午9:45:35
     * @param: @param jsonData
     * @param: @param beanType
     * @param: @return
     * @return: T
     */
    public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
        try {
            T t = MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @throws
     * @Title: jsonToList
     * @Description: 将json数据转换成pojo对象list
     * @author: 天刀-盛泽荣
     * @date: 2018年6月10日 下午9:45:24
     * @param: @param jsonData
     * @param: @param beanType
     * @param: @return
     * @return: List<T>
     */
    public static <T> List<T> jsonToList(String jsonData, Class<T> beanType) {
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
        try {
            List<T> list = MAPPER.readValue(jsonData, javaType);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
