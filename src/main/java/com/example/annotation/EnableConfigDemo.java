package com.example.annotation;

import com.example.config.ConfigurationDemo;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description:
 * @Author: admin
 * @Date: 2020/10/26 9:33
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(ConfigurationDemo.class)
public @interface EnableConfigDemo {

    String value() default "";
}
