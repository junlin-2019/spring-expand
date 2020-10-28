package com.example.config;

import com.example.annotation.EnableRegistrar;
import com.example.annotation.MapperDemo;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: admin
 * @Date: 2020/10/26 10:50
 */
public class RegistrarDemo implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        AnnotationAttributes annotationAttributes = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(EnableRegistrar.class.getName(), false));
        String[] scanPackages = annotationAttributes.getStringArray("scanPackage");
        List<String> classNames = new ArrayList<String>();
        for (String scanPackage : scanPackages) {
            classNames.addAll(scanBasePackage(scanPackage));
        }
        try {
            for (String className : classNames) {
                Class<?> aClass = Class.forName(className);
                if(aClass.isAnnotationPresent(MapperDemo.class)){
                    BeanDefinitionBuilder bdb1 = BeanDefinitionBuilder.rootBeanDefinition(aClass);
                    BeanDefinition beanDefinition1 = bdb1.getBeanDefinition();
                    registry.registerBeanDefinition(aClass.getName(), beanDefinition1);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


    private List<String> scanBasePackage(String basePackName){
        List<String> classNames = new ArrayList<String>();
        String path = basePackName.replace(".","/");
        System.out.println(path);
        URL url = this.getClass().getClassLoader().getResource(path);
        System.out.println(url);
        File dir = new File(url.getFile());
        File[] files = dir.listFiles();
        for (File file: files) {
            if(file.isDirectory()){
                scanBasePackage(basePackName +"."+file.getName());
            }else if(file.isFile()){
                classNames.add(basePackName +"." + file.getName().replace(".class",""));
                System.out.println("扫描到的类有" + basePackName +"." + file.getName().replace(".class",""));
            }
        }
        return classNames;
    }

}
