package com.burst.text.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName:  Log
 * @Description:日志
 * @author: 天刀-盛泽荣
 * @date:   2018年6月10日 下午10:43:49
 *
 * @Copyright: 2018 www.tydic.com Inc. All rights reserved.
 * 注意：本内容仅限于***内部传阅，禁止外泄以及用于其他的商业目
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    /** 要执行的操作类型比如：add操作 **/
    String operationType() default "";

    /** 要执行的具体操作比如：添加用户 **/
    String operationName() default "";

    /** 日志来源：1-app客户端   2-管理系统 **/
    String logSource() default "";
}
