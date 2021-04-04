package com.jef.dbRouting.db;


import com.jef.dbRouting.DbContextHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


/**
 * Spring的动态数据源的实现
 * @author Jef
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    public static final Logger logger = LogManager.getLogger(DynamicDataSource.class);

    @Override
    protected Object determineCurrentLookupKey() {
    	// 获取当前数据源
    	return DbContextHolder.getDbKey();
    }

}