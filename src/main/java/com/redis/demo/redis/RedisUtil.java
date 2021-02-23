package com.redis.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * bitmap 主要就三个操作命令，setbit，getbit以及 bitcount
 *
 * @author Pangdb
 */
@Component
public class RedisUtil {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 设置标记位
     * <p>
     * 设置标记
     * 即setbit，主要是指将某个索引，设置为 1(设置 0 表示抹去标记)，基本语法如下
     * <p>
     * 请注意这个index必须是数字，后面的value必须是0/1
     * setbit key index 0/1
     *
     * @param key
     * @param offset
     * @param tag
     * @return
     */
    public Boolean mark(String key, long offset, boolean tag) {
        return redisTemplate.opsForValue().setBit(key, offset, tag);
    }

    public Boolean mark2(String key, long offset, boolean tag) {
        return redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.setBit(key.getBytes(), offset, tag);
            }
        });
    }

    /**
     * 判断是否标记过
     * <p>
     * 判断存在与否
     * 即 getbit key index，如果返回 1，表示存在否则不存在
     *
     * @param key
     * @param offset
     * @return
     */
    public Boolean container(String key, long offset) {
        return redisTemplate.opsForValue().getBit(key, offset);
    }

    /**
     * 统计计数
     * <p>
     * 计数
     * 即 bitcount key，统计和
     *
     * @param key
     * @return
     */
    public long bitCount(String key) {
        return redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection redisConnection) throws DataAccessException {
                return redisConnection.bitCount(key.getBytes());
            }
        });
    }
}
