package com.jef.dbRouting;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 动态数据源实现中KEY的存放工具类
 * 动态数据源实现中KEY的存放工具类：使用treadLocal的方式来保证线程安全
 */
public class DbContextHolder {
	private final static Logger logger = LogManager.getLogger(DbContextHolder.class);
	public static final String DATA_SOURCE_WRITE = "master1";
	public static final String DATA_SOURCE_WRITE2 = "master2";
	public static final String DATA_SOURCE_READ = "slave";
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
	private static final ThreadLocal<String> tableIndexHolder= new ThreadLocal<String>();
	
	
	public static void setDbKey(String dbKey) {
		contextHolder.set(dbKey);
	}

	public static String getDbKey() {
		logger.debug("数据源:{}", contextHolder.get());
		return contextHolder.get();
	}

	public static void clearDbKey() {
		contextHolder.remove();
	}
	
	public static void setTableIndex(String tableIndex){
		tableIndexHolder.set(tableIndex);
	}
	
	public static String getTableIndex(){
		return (String) tableIndexHolder.get();
	}
	public static void clearTableIndex(){
		tableIndexHolder.remove();
	}
	
	
}