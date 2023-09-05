package com.example.mysql.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @desc:
 * @author: merickbao
 * @since: 2023/9/5 22:43
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DemoAnnotation {

    // 注解标识值
    String value() default "";

    // 注解描述
    String description() default "";
}
