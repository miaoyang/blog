package com.ym.blog.api.aop;

import com.alibaba.fastjson.JSON;
import com.ym.blog.api.annotation.LogAnnotation;
import com.ym.blog.api.utils.HttpContextUtil;
import com.ym.blog.api.utils.IpUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author: Yangmiao
 * @Date: 2022/9/13 20:58
 * @Desc: 日志切面
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    @Pointcut("@annotation(com.ym.blog.api.annotation.LogAnnotation)")
    public void logPointCut(){

    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long startTime = System.currentTimeMillis();

        Object proceed = proceedingJoinPoint.proceed();

        long time = System.currentTimeMillis()-startTime;

        recordLog(time,proceedingJoinPoint);
        return proceed;
    }

    private void recordLog(long time, ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        LogAnnotation logAnnotation = method.getAnnotation(LogAnnotation.class);
        log.info("=====================log start================================");
        log.info("module:{}",logAnnotation.module());
        log.info("operation:{}",logAnnotation.operation());

        // 请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        log.info("request method:{}",className + "." + methodName + "()");

        // 请求的参数
        Object[] args = joinPoint.getArgs();
        String params = JSON.toJSONString(args[0]);
        log.info("params: {}",params);

        // 请求的ip
        log.info("ip address: {}", IpUtils.getIpAddr(HttpContextUtil.getHttpServletRequest()));

        log.info("excute time : {} ms",time);
        log.info("=====================log end================================");
    }


}
