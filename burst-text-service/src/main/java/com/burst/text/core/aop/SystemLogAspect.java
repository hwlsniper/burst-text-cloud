package com.burst.text.core.aop;

import com.burst.text.annotation.Log;
import com.burst.text.core.tools.ToolsService;
import com.burst.text.entity.TabSysLog;
import com.burst.text.enums.LogLevel;
import com.burst.text.service.log.SysLogService;
import com.burst.text.service.user.UserTokenService;
import com.burst.text.util.IdWorker;
import com.burst.text.util.JsonUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @ClassName: SystemLogAspect
 * @Description:日志切面
 * @author: 天刀-盛泽荣
 * @date: 2018年6月10日 下午11:10:32
 *
 * @Copyright: 2018 www.tydic.com Inc. All rights reserved.
 *             注意：本内容仅限于***内部传阅，禁止外泄以及用于其他的商业目
 */
@Aspect
@Component
public class SystemLogAspect {

    @Autowired
    private ToolsService toolsService;

    @Autowired
    private UserTokenService userTokenService;

    @Autowired
    private SysLogService sysLogService;

    public static final IdWorker idWork = new IdWorker();

    private static final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);

    /**
     * @Title: ServiceAspect
     * @Description: service 切点
     * @author: 天刀-盛泽荣
     * @date: 2018年6月10日 下午10:56:46
     * @param:
     * @return: void
     * @throws
     */
    @Pointcut("execution (* com.burst.text.service..*.*(..))")
    public void ServiceAspect() {

    }

    /**
     * @Title: doBefore
     * @Description: 前置通知 用于拦截 service 层记录用户的操作
     * @author: 天刀-盛泽荣
     * @date: 2018年6月10日 下午10:58:32
     * @param joinPoint 切点
     * @return: void
     * @throws
     */
    /**@Before("ServiceAspect()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("==========执行controller前置通知===============");
        if (logger.isInfoEnabled()) {
            logger.info("before " + joinPoint);
        }
    }*/

    /**
     * @Title: around
     * @Description: 配置 service 环绕通知,使用在方法aspect()上注册的切入点
     * @author: 天刀-盛泽荣
     * @date: 2018年6月10日 下午10:59:29
     * @param joinPoint 切点
     * @return: void
     * @throws
     */
    /**@Around("ServiceAspect()")
    public void around(JoinPoint joinPoint) {
        System.out.println("==========开始执行 service 环绕通知===============");
        long start = System.currentTimeMillis();
        try {
            ((ProceedingJoinPoint) joinPoint).proceed();
            long end = System.currentTimeMillis();
            if (logger.isInfoEnabled()) {
                logger.info("around " + joinPoint + "\tUse time : " + (end - start) + " ms!");
            }
            System.out.println("==========结束执行controller环绕通知===============");
        } catch (Throwable e) {
            long end = System.currentTimeMillis();
            if (logger.isInfoEnabled()) {
                logger.info("around " + joinPoint + "\tUse time : " + (end - start) + " ms with exception : "
                        + e.getMessage());
            }
        }
    }*/

    /**@After("ServiceAspect()")
    public void after(JoinPoint joinPoint) {
        String userId = userTokenService.queryUserIdForToken();
        // 请求的IP
        String ip = toolsService.getIP();
        //UUID
        String uuid = toolsService.getUUID();
        try {

            String targetName = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            Object[] arguments = joinPoint.getArgs();
            Class targetClass = Class.forName(targetName);
            Method[] methods = targetClass.getMethods();
            String operationType = "";
            String operationName = "";
            String logSource = "";
            for (Method method : methods) {
                if (method.getName().equals(methodName)) {
                    Class[] clazzs = method.getParameterTypes();
                    if (clazzs.length == arguments.length) {
                        operationType = method.getAnnotation(Log.class).operationType();
                        operationName = method.getAnnotation(Log.class).operationName();
                        logSource = method.getAnnotation(Log.class).logSource();
                        break;
                    }
                }
            }
            // ========控制台输出========= //
            System.out.println("=====后置通知开始=====");
            System.out.println("请求方法:"
                    + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()")
                    + "." + operationType);
            System.out.println("方法描述:" + operationName);
            System.out.println("请求人:" + userId);
            System.out.println("请求IP:" + ip);
            // ========数据库日志========= //
            TabSysLog log = new TabSysLog();
            //String id = "log"+idWork.nextId();
            log.setId(idWork.nextId()+"");
            log.setUserId(userId);
            log.setOperate(operationName);
            log.setNode(ip);
            log.setLogContent(null);
            log.setMethod((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()")+ "." + operationType);
            log.setParam(null);
            log.setLogLevel(LogLevel.LOG_LEVEL_NORMAL.getLevelCode());
            log.setLogSource(logSource);

            // 保存数据库
            sysLogService.saveSysLog(log);
            System.out.println("=====后置通知结束=====");
        } catch (Exception e) {
            // 记录本地异常日志
            logger.error("==后置通知异常==");
            logger.error("异常信息:{}", e.getMessage());
        }
    }*/

    /**
     * @Title: afterReturn
     * @Description: 配置后置返回通知,使用在方法aspect()上注册的切入点
     * @author: 天刀-盛泽荣
     * @date: 2018年6月11日 下午9:47:24
     * @param: @param joinPoint
     * @return: void
     * @throws
     */
    /**@AfterReturning("ServiceAspect()")
    public void afterReturn(JoinPoint joinPoint) {
        System.out.println("=====执行controller后置返回通知=====");
        if (logger.isInfoEnabled()) {
            logger.info("afterReturn " + joinPoint);
        }
    }*/

    /**
     * @Title: doAfterThrowing
     * @Description: 异常通知 用于拦截记录异常日志
     * @author: 天刀-盛泽荣
     * @date: 2018年6月11日 下午9:50:01
     * @param: @param joinPoint
     * @param: @param e
     * @return: void
     * @throws
     */
    @AfterThrowing(pointcut = "ServiceAspect()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {

        String userId = userTokenService.queryUserIdForToken();
        // 请求的IP
        String ip = toolsService.getIP();
        //UUID
        String uuid = toolsService.getUUID();

        String params = "";
        if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
            for (int i = 0; i < joinPoint.getArgs().length; i++) {
                params += JsonUtils.objectToJson(joinPoint.getArgs()[i]) + ";";
            }
        }
        try {

            String targetName = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            Object[] arguments = joinPoint.getArgs();
            Class targetClass = Class.forName(targetName);
            Method[] methods = targetClass.getMethods();
            String operationType = "";
            String operationName = "";
            String logSource = "";
            for (Method method : methods) {
                if (method.getName().equals(methodName)) {
                    Class[] clazzs = method.getParameterTypes();
                    if (clazzs.length == arguments.length) {
                        operationType = method.getAnnotation(Log.class).operationType();
                        operationName = method.getAnnotation(Log.class).operationName();
                        logSource = method.getAnnotation(Log.class).logSource();
                        break;
                    }
                }
            }
            /* ========控制台输出========= */
            System.out.println("=====异常通知开始=====");
            System.out.println("异常代码:" + e.getClass().getName());
            System.out.println("异常信息:" + e.getMessage());
            System.out.println("异常方法:"
                    + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()")
                    + "." + operationType);
            System.out.println("方法描述:" + operationName);
            System.out.println("请求人:" + userId);
            System.out.println("请求IP:" + ip);
            System.out.println("请求参数:" + params);

            TabSysLog log = new TabSysLog();
            log.setId(idWork.nextId()+"");
            log.setUserId(userId);
            log.setOperate(operationName);
            log.setNode(ip);
            log.setLogContent(e.getMessage());
            log.setMethod((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()")+ "." + operationType);
            log.setParam(params);
            log.setLogLevel(LogLevel.LOG_LEVEL_ERROR.getLevelCode());
            log.setLogSource(logSource);

            // 保存数据库
            sysLogService.saveSysLog(log);
            System.out.println("=====异常通知结束=====");
        } catch (Exception ex) {
            // 记录本地异常日志
            logger.error("==异常通知异常==");
            logger.error("异常信息:{}", ex.getMessage());
        }
        /* ==========记录本地异常日志========== */
        logger.error("异常方法:{}异常代码:{}异常信息:{}参数:{}", joinPoint.getTarget().getClass().getName() + joinPoint.getSignature().getName(), e.getMessage());
    }
}
