package com.example.config;

import com.example.beans.TestBean01;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: admin
 * @Date: 2020/10/26 9:35
 */
@Configuration
public class ConfigurationDemo {

    @Bean
    public TestBean01 getTestBean01(){
        return  new TestBean01();
    }

}
