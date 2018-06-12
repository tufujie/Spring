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
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-mvc.xml");
        return context;
    }
}
