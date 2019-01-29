package com.jef.redis;

import com.jef.utils.MD5Utils;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Set;

/**
 * 封装redis 缓存服务器服务接口
 * @author Jef
 * @create 2018/7/13 10:26
 */
//@Service(value = "redisService")
public class RedisServiceImpl implements RedisService{
    private static String redisCode = "utf-8";
    private static final Logger logger = Logger.getLogger(RedisServiceImpl.class);

    /**
     * @param key
     */
    @Override
    public long del(final byte[] key) {
        return (Long) redisTemplate.execute(new RedisCallback() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.del(key);
            }
        });
    }

    /**
     * @param keys
     */
    @Override
    public long del(final String... keys) {
        return (Long) redisTemplate.execute(new RedisCallback() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                long result = 0;
                for (int i = 0; i < keys.length; i++) {
                    result = connection.del(keys[i].getBytes());
                }
                return result;
            }
        });
    }

    /**
     * @param key
     * @param value
     * @param liveTime
     */
    @Override
    public void set(final byte[] key, final byte[] value, final long liveTime) {
        redisTemplate.execute(new RedisCallback() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                connection.set(key, value);
                if (liveTime > 0) {
                    connection.expire(key, liveTime);
                }
                return 1L;
            }
        });
    }

    /**
     * @param key
     * @param value
     * @param liveTime
     */
    @Override
    public void set(String key, String value, long liveTime) {
        this.set(key.getBytes(), value.getBytes(), liveTime);
    }

    /**
     * @param key
     * @param value
     */
    @Override
    public void set(String key, String value) {
        this.set(key, value, 0L);
    }

    /**
     * @param key
     * @param value
     */
    @Override
    public void set(byte[] key, byte[] value) {
        this.set(key, value, 0L);
    }

    /**
     * @param key
     * @return
     */
    @Override
    public String get(final String key) {
        return (String) redisTemplate.execute(new RedisCallback() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                try {
                    return new String(connection.get(key.getBytes()), redisCode);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                return "";
            }
        });
    }

    /**
     * 添加key value (字节)(序列化)
     * @param key
     */
    @Override
    public byte[] get(final byte[] key){
        String value = (String)redisTemplate.execute(new RedisCallback() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                try {
                    if(connection.get(key)!=null){
                        return new String(connection.get(key), redisCode);
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });
        if(value!=null){
            return value.getBytes();
        }
        return null;
    }

    /**
     * @param pattern
     * @return
     * @return
     */
    @Override
    public Set setkeys(String pattern) {
        return redisTemplate.keys(pattern);

    }

    /**
     * @param key
     * @return
     */
    @Override
    public boolean exists(final String key) {
        return (Boolean) redisTemplate.execute(new RedisCallback() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.exists(key.getBytes());
            }
        });
    }

    /**
     * @return
     */
    @Override
    public String flushDB() {
        return (String) redisTemplate.execute(new RedisCallback() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                connection.flushDb();
                return "ok";
            }
        });
    }

    /**
     * @return
     */
    @Override
    public long dbSize() {
        return (Long) redisTemplate.execute(new RedisCallback() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.dbSize();
            }
        });
    }

    /**
     * @return
     */
    @Override
    public String ping() {
        return (String) redisTemplate.execute(new RedisCallback() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.ping();
            }
        });
    }

    public RedisServiceImpl(RedisTemplate redisTemplate, String jdbc ) {
        this.redisTemplate = redisTemplate;
        if (jdbc != null) {
            this.db = MD5Utils.getMD5Code(jdbc);
        }else{
            this.db = "";
        }

    }

    private RedisTemplate redisTemplate;

    // 区分数据库
    private String db;

    // 置入对象
    @Override
    public void putObject(String objKey, String key, Object obj, boolean limitSize) {
        try{
            if(key==null || obj ==null) {
                return ;
            }
            //计算obj大小，超过10M不允许存储
            if(limitSize){

            }
            redisTemplate.opsForHash().put(this.db+objKey, key, obj);
        } catch(Exception e) {

            logger.error("objKey:"+objKey+" key:"+key);
            logger.error("obj："+obj);
            logger.error("error",e);
        }
    }

    //获取对象
    @Override
    public Object getObject(String objKey, String key) {
        try{
            if(key!=null){
                return (Object) redisTemplate.opsForHash().get(this.db+objKey, key);
            }
        } catch(Exception e){
            logger.error("objKey:"+objKey+" key:"+key);
            logger.error("error",e);
            //	if(objKey!=null && key!=null){
            //	//如果更新版本，反序列化错误，则清理key
            //	this.deleteObject(this.db+objKey, key);
            //	}
        }

        return null;
    }

    //删除key
    @Override
    public void deleteObject(String objKey, String key) {
        try{
            redisTemplate.opsForHash().delete(this.db+objKey,key);
        } catch(Exception e) {

            logger.error("objKey:"+objKey+" key:"+key);
            logger.error("error",e);
        }
    }

    //获取所有key
    @Override
    public Set getKeys(String objKey) {
        return redisTemplate.opsForHash().keys(this.db+objKey);
    }

    //获得某个Ojbkey的size
    @Override
    public Long size(String objKey) {
        try {
            return redisTemplate.opsForHash().size(this.db+objKey);
        }catch (Exception e) {
            logger.error("objKey:"+objKey );
            logger.error("error",e);

            return Long.valueOf("0");
        }
    }

    // 删除所有key
    @Override
    public void deleteAll(String objKey) {
        Set keys = this.getKeys(objKey);
        if (keys != null) {
            Iterator it = keys.iterator();
            while(it.hasNext()){
                String key = (String) it.next();
                try {
                    redisTemplate.opsForHash().delete(this.db+objKey,key);
                } catch (Exception e) {
                    logger.error("objKey:"+objKey+" key:"+key);
                    logger.error("error",e);
                }
            }
        }
    }
}