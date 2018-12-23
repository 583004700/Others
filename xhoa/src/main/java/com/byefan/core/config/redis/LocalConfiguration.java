//package com.byefan.core.config.redis;
//
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cache.interceptor.KeyGenerator;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
//
//import java.io.Serializable;
//
//@Slf4j
//@Configuration
//@EnableCaching//启用缓存
//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 600)
////    @Profile({"pro"})
//public class LocalConfiguration extends CachingConfigurerSupport {
//    //从application.properties中获得以下参数
//    @Value("${spring.redis.host}")
//    private String host;
//    @Value("${spring.redis.port}")
//    private Integer port;
//    @Value("${spring.redis.password}")
//    private String password;
//    @Value("${spring.redis.timeout}")
//    private long timeout;
//
//    /**
//     * 缓存管理器
//     *
//     * @param factory
//     * @return
//     */
//    @Bean
//    public CacheManager cacheManager(RedisConnectionFactory factory) {
//        CacheManager cacheManager = RedisCacheManager.create(factory);
//        return cacheManager;
//    }
//
//    @Bean
//    public RedisTemplate<Serializable, Serializable> redisTemplate(
//            JedisConnectionFactory redisConnectionFactory) {
//        log.info("------------------------------------------");
//        RedisTemplate<Serializable, Serializable> redisTemplate = new RedisTemplate<Serializable, Serializable>();
//        //key序列化方式;（不然会出现乱码;）,但是如果方法上有Long等非String类型的话，会报类型转换错误；
//        //所以在没有自己定义key生成策略的时候，以下这个代码建议不要这么写，可以不配置或者自己实现 ObjectRedisSerializer
//        //或者JdkSerializationRedisSerializer序列化方式;
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
//        redisTemplate
//                .setValueSerializer(new JdkSerializationRedisSerializer());
//        redisTemplate
//                .setHashValueSerializer(new JdkSerializationRedisSerializer());
//        //以上4条配置可以不用
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//        return redisTemplate;
//    }
//
//    @Bean
//    public JedisConnectionFactory redisConnectionFactory() {
//        JedisConnectionFactory factory = new JedisConnectionFactory();
//        factory.setHostName(host);
//        factory.setPort(port);
//        factory.setPassword(password);
//
//        return factory;
//    }
//
//    /**
//     * 自定义key.
//     * 此方法将会根据类名+方法名+所有参数的值生成唯一的一个key
//     */
//    @Bean
//    @Override
//    public KeyGenerator keyGenerator() {
//        return (target, method, objects) -> {
//            StringBuilder sb = new StringBuilder();
//            sb.append(target.getClass().getName());
//            sb.append("::" + method.getName() + ":");
//            for (Object obj : objects) {
//                sb.append(obj.toString());
//            }
//            return sb.toString();
//        };
//    }
//}