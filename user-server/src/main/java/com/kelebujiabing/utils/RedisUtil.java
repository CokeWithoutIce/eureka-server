package com.kelebujiabing.utils;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component("redisUtil")
public class RedisUtil {

	//private static Logger logger = Logger.getLogger(RedisUtil.class);

    @Resource(name = "redisTemplate")
	private RedisTemplate<Serializable, Object> redisTemplate;

    public final static String PC_TOKEN_KEY = "ke_le_bu_jia_bingUser";


    //秒数
	private static final long CACHE_EXPIRE_TIME = 10000 * 24 * 60 * 60L;

	//公共配置项秒数
    public static final long COMMONOPTION_CACHE_EXPIRE_TIME = 10000 * 24 * 60 * 60L;

    /**
     * 批量删除对应的value
     *
     * @param keys
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 批量删除key
     *
     * @param pattern
     */
    public void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0)
            redisTemplate.delete(keys);
    }

    /**
     * 删除对应的value
     *
     * @param key
     */
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    public Object get(final String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }

    /**
     * 读取缓存
     *
     * @param key
     * @param dbIndex
     * @return
     */
    public Object get(final String key,int dbIndex) {
        Object result = null;
        JedisConnectionFactory factory =
                (JedisConnectionFactory) redisTemplate.getConnectionFactory();
        factory.setDatabase(dbIndex);//dbindex就是你想切换的db
        redisTemplate.setConnectionFactory(factory);
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }




    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value) {
    	return set(key, value, CACHE_EXPIRE_TIME);
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
           // logger.error("set cache error", e);
        }
        return result;
    }

    public long increment(final String key , long delta){
         return redisTemplate.opsForValue().increment(key, delta);
    }

    public void setRedisTemplate(RedisTemplate<Serializable, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

//    //反序列化获取对象
//    public HsUsrlist queryByJdkSer(final String key) {
//        return  (HsUsrlist)redisTemplate.getValueSerializer().deserialize((byte[]) redisTemplate.opsForValue().get(key)) ;
//    }
}
