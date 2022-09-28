package com.ym.blog.api.annotation;

import java.lang.annotation.*;

/**
 * 缓存
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface CacheAnnotation {

    // 过期时间
    long expireTime() default 1*60*1000;

    String name() default "";
}
