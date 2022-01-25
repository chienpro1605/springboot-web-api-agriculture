package com.example.project_agriculture.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import redis.clients.jedis.Jedis;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public abstract class BaseRedisCache {
    public BaseRedisCache() {
    }

    private Jedis getConnection() {
        return RedisConnectionFactory.getPool().getResource();
    }

    protected void sadd(String key, String value) {
        try {
            Jedis jedis = this.getConnection();
            Throwable var = null;
            try {
                jedis.sadd(key, value);
            } catch (Throwable var1) {
                var = var1;
            } finally {
                if (jedis != null) {
                    if (var != null) {
                        try {
                            jedis.close();
                        } catch (Throwable var2) {
                            var.addSuppressed(var2);
                        }
                    } else {
                        jedis.close();
                    }
                }
            }
        } catch (Exception ex) {
            log.error(ex.toString());
        }
    }

    protected Set<String> smembers(String key) {
        try {
            Jedis jedis = this.getConnection();
            Throwable var1 = null;

            Set result;
            try {
                result = jedis.smembers(key);
            } catch (Throwable var2) {
                var1 = var2;
                throw var2;
            } finally {
                if (jedis != null) {
                    if (var1 != null) {
                        try {
                            jedis.close();
                        } catch (Throwable var3) {
                            var1.addSuppressed(var3);
                        }
                    } else {
                        jedis.close();
                    }
                }

            }

            return result;
        } catch (Exception ex) {
            log.error(ex.toString());
            return Collections.EMPTY_SET;
        }
    }

    protected void srem(String key, String value) {
        try {
            Jedis jedis = this.getConnection();
            Throwable var = null;
            try {
                jedis.srem(key, value);
            } catch (Throwable var1) {
                var = var1;
            } finally {
                if (jedis != null) {
                    if (var != null) {
                        try {
                            jedis.close();
                        } catch (Throwable var2) {
                            var.addSuppressed(var2);
                        }
                    } else {
                        jedis.close();
                    }
                }
            }
        } catch (Exception ex) {
            log.error(ex.toString());
        }
    }

    protected void hmset(String key, Map<String, String> value) {
        try {
            Jedis jedis = this.getConnection();
            Throwable var = null;
            try {
                jedis.hmset(key, value);
            } catch (Throwable var1) {
                var = var1;
            } finally {
                if (jedis != null) {
                    if (var != null) {
                        try {
                            jedis.close();
                        } catch (Throwable var2) {
                            var.addSuppressed(var2);
                        }
                    } else {
                        jedis.close();
                    }
                }
            }
        } catch (Exception ex) {
            log.error(ex.toString());
        }
    }

    protected void hdel(String key, String... values) {
        try {
            Jedis jedis = this.getConnection();
            Throwable var = null;
            try {
                jedis.hdel(key, values);
            } catch (Throwable var1) {
                var = var1;
            } finally {
                if (jedis != null) {
                    if (var != null) {
                        try {
                            jedis.close();
                        } catch (Throwable var2) {
                            var.addSuppressed(var2);
                        }
                    } else {
                        jedis.close();
                    }
                }
            }
        } catch (Exception ex) {
            log.error(ex.toString());
        }
    }

    protected List<String> hmget(String key) {
        try {
            Jedis jedis = this.getConnection();
            Throwable var = null;
            List<String> result;
            try {
                result = jedis.hmget(key);
            } catch (Throwable var2) {
                var = var2;
                throw var2;
            } finally {
                if (jedis != null) {
                    if (var != null) {
                        try {
                            jedis.close();
                        } catch (Throwable var3) {
                            var.addSuppressed(var3);
                        }
                    } else {
                        jedis.close();
                    }
                }

            }
            return result;
        } catch (Exception ex) {
            log.error(ex.toString());
            return Collections.EMPTY_LIST;
        }
    }

    protected void lpush(String key, String... values) {
        try {
            Jedis jedis = this.getConnection();
            Throwable var = null;
            try {
                jedis.lpush(key, values);
            } catch (Throwable var1) {
                var = var1;
            } finally {
                if (jedis != null) {
                    if (var != null) {
                        try {
                            jedis.close();
                        } catch (Throwable var2) {
                            var.addSuppressed(var2);
                        }
                    } else {
                        jedis.close();
                    }
                }
            }
        } catch (Exception ex) {
            log.error(ex.toString());
        }
    }

    protected void lrem(String key, Long count, String value) {
        try {
            Jedis jedis = this.getConnection();
            Throwable var = null;
            try {
                jedis.lrem(key, count, value);
            } catch (Throwable var1) {
                var = var1;
            } finally {
                if (jedis != null) {
                    if (var != null) {
                        try {
                            jedis.close();
                        } catch (Throwable var2) {
                            var.addSuppressed(var2);
                        }
                    } else {
                        jedis.close();
                    }
                }
            }
        } catch (Exception ex) {
            log.error(ex.toString());
        }
    }

    protected String ltrim(String key, Long start, Long stop) {
        try {
            Jedis jedis = this.getConnection();
            Throwable var = null;
            String result;
            try {
                result = jedis.ltrim(key, start, stop);
            } catch (Throwable var2) {
                var = var2;
                throw var2;
            } finally {
                if (jedis != null) {
                    if (var != null) {
                        try {
                            jedis.close();
                        } catch (Throwable var3) {
                            var.addSuppressed(var3);
                        }
                    } else {
                        jedis.close();
                    }
                }

            }
            return result;
        } catch (Exception ex) {
            log.error(ex.toString());
            return new String();
        }
    }
}

