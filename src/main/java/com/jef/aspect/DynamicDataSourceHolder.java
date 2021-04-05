package com.jef.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 动态数据源Holder， 在DynamicDataSource引用到， 在DataSourceAspect设置值
 * @author Jef
 * @date: 2021/3/29 10:52
 */
public class DynamicDataSourceHolder {
    private final static Logger logger = LogManager.getLogger(DynamicDataSourceHolder.class);
    public static final String DATA_SOURCE_WRITE = "master";
    public static final String DATA_SOURCE_READ = "slave";

    public static final ThreadLocal<String> holder = new ThreadLocal<String>();

    public static void putDataSource(String name) {
        holder.set(name);
    }

    public static String getDataSource() {
        logger.debug("data_source_type:{}", holder.get());
        if (holder.get() == null) {
            return DATA_SOURCE_WRITE;
        } else {
            return holder.get();
        }
    }
}