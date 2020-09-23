package com.jef.redis;

import com.jef.common.context.SpringContextHolder;
import com.jef.common.utils.SpringPropertiesUtil;
import org.apache.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

/**
 * @author Jef
 * @create 2018/7/13 10:24
 */
public class RedisServiceFactory {
    private static final Logger logger = Logger.getLogger(RedisServiceFactory.class);

    // 单例工厂
    private static RedisServiceFactory fatory ;
    // redis服务
    private RedisService redisService;

    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    private RedisServiceFactory() {

    }

    /**
     * 返回redis实例
     * @return
     */
    public static RedisService getInstance(){
        // 工厂返回实例
        return getSingleton().getRedisService();
    }

    // 如果fatory未创建，则创建单例
    private static RedisServiceFactory getSingleton() {
        if (fatory == null) {
            creatFactory();
        }
        return fatory;
    }

    private RedisService getRedisService() {
        if (redisTemplate == null) {
            creatRedisTemplate();
        }
        if (stringRedisTemplate == null) {
            creatStringRedisTemplate();
        }
        if (redisService == null) {
            creatRedisServiceImpl();
        }
        return redisService;
    }

    // 一个时间内只能有一个线程得到执行
    private synchronized static void creatFactory() {
        if (fatory == null) {
            fatory = new RedisServiceFactory();
        }
    }


    // 一个时间内只能有一个线程得到执行
    private synchronized void creatRedisTemplate() {
        if (this.redisTemplate == null) {
            logger.info("redis初始化");
            // 从Spring获取redisTemplate
            this.redisTemplate = SpringContextHolder.getBean("redisTemplate");
        }
    }

    // 一个时间内只能有一个线程得到执行
    private synchronized void creatStringRedisTemplate() {
        if (this.stringRedisTemplate == null) {
            logger.info("stringRedis初始化");
            // 从Spring获取redisTemplate
            this.stringRedisTemplate = SpringContextHolder.getBean("stringRedisTemplate");
        }
    }

    // 一个时间内只能有一个线程得到执行
    private synchronized void creatRedisServiceImpl() {
        if (redisService == null) {
            String db = this.difdb();
            redisService = new RedisServiceImpl(redisTemplate, stringRedisTemplate, db);
            logger.info("redis初始化完成,db:" + db);
        }
    }


    private String difdb() {
        // 是否区分数据库缓存
        String difdb = SpringPropertiesUtil.getProperty("redis.diffdb");
        String db = "";
        if (difdb != null && Boolean.valueOf(difdb)) {
            db = SpringPropertiesUtil.getProperty("jdbc.url");
        }
        return db;
    }


}