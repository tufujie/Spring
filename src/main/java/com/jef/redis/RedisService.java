package com.jef.redis;

import java.util.Set;

/**
 * redis 的操作开放接口
 * @create 20180713
 */
public interface RedisService {

    /**
     * 通过key删除
     * @param keys
     */
    long del(String... keys);

    /**
     * @param key
     */
     long del(final byte[] key);

    /**
     * 添加key value 并且设置存活时间(byte)
     * @param key
     * @param value
     * @param liveTime
     */
    void set(byte[] key, byte[] value, long liveTime);

    /**
     * 添加key value 并且设置存活时间
     * @param key
     * @param value
     * @param liveTime
     * 单位秒
     */
    void set(String key, String value, long liveTime);

    /**
     * 添加key value
     * @param key
     * @param value
     */
    void set(String key, String value);

    /**
     * 添加key value (字节)(序列化)
     * @param key
     * @param value
     */
    void set(byte[] key, byte[] value);

    /**
     * 获取redis value (String)
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 添加key value (字节)(序列化)
     * @param key
     */
    byte[] get(byte[] key);

    /**
     * 通过正则匹配keys
     * @param pattern
     * @return
     * @return
     */
    Set setkeys(String pattern);

    /**
     * 检查key是否已经存在
     * @param key
     * @return
     */
    boolean exists(String key);

    /**
     * 清空redis 所有数据
     * @return
     */
    String flushDB();

    /**
     * 查看redis里有多少数据
     */
    long dbSize();

    /**
     * 检查是否连接成功
     * @return
     */
    String ping();

    /**
     * 存放对象
     * @param obj
     */
    void putObject(String objKey, String key, Object obj, boolean limitSize);

    /**
     * 获取对象
     * @param key
     * @return
     */
    Object getObject(String objKey, String key);

    /**
     * 删除对象
     * @param objKey
     * @param key
     */
    void deleteObject(String objKey, String key) ;

    //获取所有key
    Set getKeys(String objKey) ;

    //获得某个objKey size
    Long size(String objKey) ;

    //删除所有key
    void deleteAll(String objKey) ;

}