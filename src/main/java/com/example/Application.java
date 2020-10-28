package com.example;

import com.example.annotation.EnableConfigDemo;
import com.example.annotation.EnableRegistrar;
import com.example.annotation.EnableSelectorDemo;
import com.example.beans.HpDataSource;
import com.example.mapper.Mapper01;
import com.example.mapper.Mapper02;
import com.example.mapper.Mapper03;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Description:
 * @Author: admin
 * @Date: 2020/9/28 16:32
 */
@SpringBootApplication
@EnableConfigDemo
@EnableSelectorDemo(dataSourcetype="hp")
@EnableRegistrar(scanPackage = "com.example.mapper")
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
        HpDataSource bean =(HpDataSource) run.getBean("com.example.beans.HpDataSource");
        bean.sayHello();
        Mapper01 mapper01 = run.getBean(Mapper01.class);
        mapper01.sayHello();
        Mapper02 mapper02 = run.getBean(Mapper02.class);
        mapper02.sayHello();
        Mapper03 mapper03 = run.getBean(Mapper03.class);
        mapper03.sayHello();

    }
}
