package com.example.annotation;

import com.example.config.RegistrarDemo;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description:
 * @Author: admin
 * @Date: 2020/10/26 10:26
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(RegistrarDemo.class)
public @interface EnableRegistrar {
    String[] scanPackage() default "";
}
