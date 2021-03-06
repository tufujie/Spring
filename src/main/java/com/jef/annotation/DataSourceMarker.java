package com.jef.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 添加注解跳过动态数据源切换
 * @author Jef
 * @date: 2021/3/29 10:50
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface DataSourceMarker {
    boolean readOnly() default false;
}