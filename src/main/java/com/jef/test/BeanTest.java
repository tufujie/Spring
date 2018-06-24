package com.jef.test;

import com.jef.common.utils.ContextUtils;
import com.jef.service.IPersonServive;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

/**
 * Spring bean测试
 */
public class BeanTest {
    public static void main(String[] args) {

    }

    @Test
    public void useChopTest() {
        ApplicationContext applicationContext = ContextUtils.getContextFromBeansXML();
        // 获取 id="chineseService"的bean
        IPersonServive chineseService = applicationContext.getBean("chineseService", IPersonServive.class);
        // 调用 useAxe() 方法
        chineseService.useAxe();
        // 获取 id="oldChineseService"的bean
        IPersonServive oldChineseService = applicationContext.getBean("oldChineseService", IPersonServive.class);
        // 调用 useAxe() 方法
        oldChineseService.useAxe();
        // 获取 id="originalChineseService"的bean
        IPersonServive originalChineseService = applicationContext.getBean("originalChineseService", IPersonServive.class);
        // 调用 useAxe() 方法
        originalChineseService.useAxe();
    }
}
