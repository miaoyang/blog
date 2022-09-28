package com.ym.blog.api.aop;

import com.alibaba.fastjson.JSON;
import com.ym.blog.api.annotation.CacheAnnotation;
import com.ym.blog.api.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.Duration;

/**
 * @Author: Yangmiao
 * @Date: 2022/9/14 09:53
 * @Desc:
 */
@Aspect
@Component
@Slf4j
public class CacheAspect {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Pointcut("@annotation(com.ym.blog.api.annotation.CacheAnnotation)")
    public void cachePointCut(){

    }

    @Around("cachePointCut()")
    public Object cacheAround(ProceedingJoinPoint joinPoint){
        try {
            Signature signature = joinPoint.getSignature();
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = signature.getName();

            Class[] parameterTypes = new Class[joinPoint.getArgs().length];
            Object[] args = joinPoint.getArgs();
            //参数
            String params = "";
            for (int i = 0; i < args.length; i++) {
                if (args[i] != null) {
                    params += JSON.toJSONString(args[i]);
                    parameterTypes[i] = args[i].getClass();
                } else {
                    parameterTypes[i] = null;
                }
            }

            if (!StringUtils.isEmpty(params)) {
                params = DigestUtils.md5Hex(params);
            }

            Method method = joinPoint.getSignature().getDeclaringType().getMethod(methodName, parameterTypes);

            CacheAnnotation cacheAnnotation = method.getAnnotation(CacheAnnotation.class);
            // 过期时间
            long expireTime = cacheAnnotation.expireTime();
            // 名称
            String name = cacheAnnotation.name();

            //先从redis获取
            String redisKey = name + "::" + className+"::"+methodName+"::"+params;
            String redisValue = redisTemplate.opsForValue().get(redisKey);
            if (StringUtils.isNotEmpty(redisValue)){
                log.debug("已缓存过 {}::{}",className,methodName);
                return JSON.parseObject(redisValue, Result.class);
            }
            // 存入
            Object proceed = joinPoint.proceed();
            redisTemplate.opsForValue().set(redisKey,JSON.toJSONString(proceed), Duration.ofMillis(expireTime));
            log.debug("存入缓存 {}::{}",className,methodName);
            return proceed;

        }catch (NoSuchMethodException e){
            log.error("method error: {}",e);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return Result.fail(-999,"系统错误");
    }

}
