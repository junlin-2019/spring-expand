package com.example.annotation;

import com.example.config.SelectorDemo;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description:
 * @Author: admin
 * @Date: 2020/10/26 9:40
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(SelectorDemo.class)
public @interface EnableSelectorDemo {

    String dataSourcetype() default "druid";
}
