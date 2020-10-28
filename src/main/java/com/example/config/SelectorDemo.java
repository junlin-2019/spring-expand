package com.example.config;

import com.example.annotation.EnableSelectorDemo;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;
import java.util.Set;

/**
 * @Description:
 * @Author: admin
 * @Date: 2020/10/26 9:41
 */
public class SelectorDemo implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(EnableSelectorDemo.class.getName(), false);
        AnnotationAttributes annotationAttributes1 = AnnotationAttributes.fromMap(annotationAttributes);
        String dataSourcetype = annotationAttributes1.getString("dataSourcetype");
        if("druid".equals(dataSourcetype)){
            return new String[]{"com.example.beans.DruidDataSource"};
        }else{
            return new String[]{"com.example.beans.HpDataSource"};
        }

    }
}
