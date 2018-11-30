package com.jef.redis.cache;

import com.jef.redis.RedisService;
import com.jef.redis.RedisServiceFactory;
import com.jef.vo.RedisVo;

import java.util.Date;

/**
 * 对象缓存
 * @author Jef
 * @create 2018/7/13 11:13
 */
public class ObjectCache {
    // 需要销毁的keys
    public static final String OBJECT_KEY = "kill_them";
    /**
     * 设置缓存
     * @param key
     * @param obj
     * @param timeOut 超时是否清理
     * @return
     * @throws Exception
     */
    public static void setCache(String objectKey, String key, Object obj, boolean timeOut) throws Exception {
        boolean limitSize = false; // 限制大小
        setCache(objectKey, key, obj, timeOut, limitSize);
    }

    public static void setCache(String objectKey, String key, Object obj, boolean timeOut, boolean limitSize) throws
            Exception {
        RedisService redisService = RedisServiceFactory.getInstance();
        if (obj == null) {
            redisService.deleteObject(objectKey, key);
            return ;
        }
        redisService.putObject(objectKey, key, obj, limitSize);
        if (timeOut) {
            // 该对象超时则需要销毁，每2个小时检查一次
            RedisVo vo = new RedisVo();
            vo.setObjectKey(objectKey);
            vo.setKey(key);
            vo.setCreateTime(new Date());
            // 需要反解析
            redisService.putObject(OBJECT_KEY,objectKey + ";" + key, vo, limitSize);

        }
    }

    /**
     * 获取缓存
     * @param key
     * @return
     * @throws Exception
     */
    public static Object getCache(String objectKey, String key) throws Exception {
        // 先从缓存获取
        RedisService redisService = RedisServiceFactory.getInstance();
        Object obj = redisService.getObject(objectKey, key);
        return obj;
    }


    /**
     * 清理缓存
     * @param key
     * @return
     * @throws Exception
     */
    public static void clearCache(String objectKey, String key) throws Exception {
        if (key == null) {
            return ;
        }
        RedisService redisService = RedisServiceFactory.getInstance();
        redisService.deleteObject(objectKey, key);
        // 同时清理超时缓存
        String timout_key = objectKey + ";" + key;
        Object obj = redisService.getObject(ObjectCache.OBJECT_KEY, timout_key);
        if(obj != null) {
            redisService.deleteObject(ObjectCache.OBJECT_KEY, timout_key);
        }
    }

    /**
     * 设置带有效期的参数缓存，注意该方法不需要ObjectKey
     * @param key
     * @param value
     * @param liveTime 有效期，单位秒
     */
    public static void setCache(String key, String value, long liveTime) {
        RedisService redisService = RedisServiceFactory.getInstance();
        if (value == null) {
            redisService.del(key);
            return;
        }
        redisService.set(key, value, liveTime);
    }

    /**
     * 获得缓存参数值，注意该方法不需要ObjectKey
     * @param key
     * @return 缓存参数值
     */
    public static String getCache(String key) {
        RedisService redisService = RedisServiceFactory.getInstance();
        String value;
        try {
            value = redisService.get(key);
        } catch (Exception e) {
            return null;
        }
        return value;
    }

}
