package com.lp.rpc.commen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2016/9/29.
 */
public class JedisTemplate{
        private JedisPool jedisPool;
        public JedisTemplate(JedisPool jedisPool) {
            this.jedisPool = jedisPool;
        }
        private Logger logger = LoggerFactory.getLogger(JedisTemplate.class);

        // 设置key并且设定一个默认失效时间
        // 设置失效时间，此处单位秒seconds
        public void set(String key, String value, int expiredseconds) {
            if (key != null && value != null && expiredseconds > 0) {
                JedisPool jedisPool = null;
                Jedis jedis = null;
                try {
                    // 获取jedis pool对象
                    jedisPool = getJedisPool();
                    if (jedisPool != null) {
                        // 从jedis pool连接池里边获取一个jedis连接对象
                        jedis = jedisPool.getResource();
                        jedis.setex(key, expiredseconds, value);
                        logger.info("jedisTemplate>>>set key={},value={},expired={} succeed", new Object[] {
                                key,
                                value,
                                expiredseconds
                        });
                    }
                } catch (Exception e) {
                    if (jedisPool != null) {
                        jedisPool.returnBrokenResource(jedis);
                    }
                    logger.error("jedisTemplate>>>set key={},value={},expired={} failed e={}", new Object[] {
                            key,
                            value,
                            expiredseconds,
                            e.getCause()
                    });
                } finally {
                    // 处理完毕后，一定将jedis连接对象释放回到连接池中
                    if (jedisPool != null) {
                        jedisPool.returnResource(jedis);
                    }
                }
            }
        }

        // 设置key-value不设置失效时间
        public void set(String key, String value) {
            if (key != null && value != null) {
                JedisPool jedisPool = null;
                Jedis jedis = null;
                try {
                    jedisPool = getJedisPool();
                    if (jedisPool != null) {
                        jedis = jedisPool.getResource();
                        jedis.set(key, value);
                        logger.info("jedisTemplate>>>set key={},value={} succeed", new Object[] {
                                key,
                                value
                        });
                    }
                } catch (Exception e) {
                    if (jedisPool != null) {
                        jedisPool.returnBrokenResource(jedis);
                    }
                    logger.error("jedisTemplate>>>set key={},value={} failed e={}", new Object[] {
                            key,
                            value,
                            e.getCause()
                    });
                } finally {
                    if (jedisPool != null) {
                        jedisPool.returnResource(jedis);
                    }
                }
            }
        }

        // 根据key查询value
        public String get(String key) {
            String value = "";
            if (null != key && !"".equals(key)) {
                JedisPool jedisPool = null;
                Jedis jedis = null;
                try {
                    jedisPool = getJedisPool();
                    if (jedisPool != null) {
                        jedis = jedisPool.getResource();
                        String tmp = jedis.get(key);
                        value = tmp != null ? tmp : value;
                        logger.info("jedisTemplate>>>get key={},value={} succeed", new Object[] {
                                key,
                                value
                        });
                    }
                } catch (Exception e) {
                    if (jedisPool != null) {
                        jedisPool.returnBrokenResource(jedis);
                    }
                    logger.error("jedisTemplate>>>get key={},value={} failed e={}", new Object[] {
                            key,
                            value,
                            e.getCause()
                    });
                } finally {
                    if (jedisPool != null) {
                        jedisPool.returnResource(jedis);
                    }
                }
            }
            return value;
        }

        // 设置hset,key-fieldKey-value值
        public void hset(String key, String fieldKey, String value) {
            if (key != null && value != null && fieldKey != null) {
                JedisPool jedisPool = null;
                Jedis jedis = null;
                try {
                    jedisPool = getJedisPool();
                    if (jedisPool != null) {
                        jedis = jedisPool.getResource();
                        jedis.hset(key, fieldKey, value);
                        logger.info("jedisTemplate>>>hset key={},fieldKey={},value={} succeed", new Object[] {
                                key,
                                fieldKey,
                                value
                        });
                    }
                } catch (Exception e) {
                    if (jedisPool != null) {
                        jedisPool.returnBrokenResource(jedis);
                    }
                    logger.error("jedisTemplate>>>hset key={},fieldKey={},value={} failed e={}", new Object[] {
                            key,
                            fieldKey,
                            value,
                            e.getCause()
                    });
                } finally {
                    if (jedisPool != null) {
                        jedisPool.returnResource(jedis);
                    }
                }
            }
        }
        // 获取hgetall key对应的值，放在map<fieldKey,value>中返回
        public Map<String, String> hgetAll(String key) {
            Map<String, String> map = new HashMap<String, String>();
            if (key != null) {
                JedisPool jedisPool = null;
                Jedis jedis = null;
                try {
                    jedisPool = getJedisPool();
                    if (jedisPool != null) {
                        jedis = jedisPool.getResource();
                        Map<String, String> tmpmap = jedis.hgetAll(key);
                        map = tmpmap != null ? tmpmap : map;
                        logger.info("jedisTemplate>>>hgetall key={},value={} succeed", new Object[] {
                                key,
                                tmpmap
                        });
                    }
                } catch (Exception e) {
                    if (jedisPool != null) {
                        jedisPool.returnBrokenResource(jedis);
                    }
                    logger.error("jedisTemplate>>>hget key={},value={},failed e={}", new Object[] {
                            key,
                            map,
                            e.getCause()
                    });
                } finally {
                    if (jedisPool != null) {
                        jedisPool.returnResource(jedis);
                    }
                }
            }
            return map;
        }
        /**
         * <pre>
         * 查询匹配keys全部key键值列表
         *
         * redis里边的keys* 命令
         */
        public Set<String> keys(String keysPattern) {
            Set<String> set = new HashSet<String>();
            if (keysPattern != null && !"".equals(keysPattern)) {
                JedisPool jedisPool = null;
                Jedis jedis = null;
                try {
                    jedisPool = getJedisPool();
                    if (jedisPool != null) {
                        jedis = jedisPool.getResource();
                        Set<String> tmp = jedis.keys(keysPattern);
                        set = tmp != null ? tmp : set;
                        logger.info("jedisTemplate>>>keys keyPattern={}, set.size={}", new Object[] {
                                keysPattern,
                                set.size()
                        });
                    }
                } catch (Exception e) {
                    if (jedisPool != null) {
                        jedisPool.returnBrokenResource(jedis);
                    }
                    logger.error("jedisTemplate>>>keys keyPattern={}, failed e={}", new Object[] {
                            keysPattern,
                            e.getCause()
                    });
                } finally {
                    if (jedisPool != null) {
                        jedisPool.returnResource(jedis);
                    }
                }
            }
            return set;
        }
        // 从hset中hget出对应的key-field对应的value值
        public String hget(String key, String fieldKey) {
            String value = "";
            if (key != null && fieldKey != null) {
                JedisPool jedisPool = null;
                Jedis jedis = null;
                try {
                    jedisPool = getJedisPool();
                    if (jedisPool != null) {
                        jedis = jedisPool.getResource();
                        String tmp = jedis.hget(key, fieldKey);
                        value = tmp != null ? tmp : value;
                        logger.info("jedisTemplate>>>hget key={},fieldKey={},value={} succeed", new Object[] {
                                key,
                                fieldKey,
                                value
                        });
                    }
                } catch (Exception e) {
                    if (jedisPool != null) {
                        jedisPool.returnBrokenResource(jedis);
                    }
                    logger.error("jedisTemplate>>>hget key={},fieldKey={},value={} failed e={}", new Object[] {
                            key,
                            fieldKey,
                            value,
                            e.getCause()
                    });
                } finally {
                    if (jedisPool != null) {
                        jedisPool.returnResource(jedis);
                    }
                }
            }
            return value;
        }
        public JedisPool getJedisPool() {
            return jedisPool;
        }
        public void setJedisPool(JedisPool jedisPool) {
            this.jedisPool = jedisPool;
        }
}

