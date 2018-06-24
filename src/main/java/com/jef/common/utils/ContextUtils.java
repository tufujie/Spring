package com.jef.common.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 工具类
 *
 * @author Jef
 * @create 2018/6/11 20:54
 */
public class ContextUtils {

    /**
     * 获取ApplicationContext
     * @return ApplicationContext
     */
    public static ApplicationContext getContext() {
        // 创建 Spring 容器
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-mvc.xml");
        return context;
    }

    /**
     * 获取ApplicationContext
     * @return ApplicationContext
     */
    public static ApplicationContext getContextFromBeansXML() {
        // 创建 Spring 容器
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/beans.xml");
        return context;
    }
}
