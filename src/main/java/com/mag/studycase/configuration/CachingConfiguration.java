package com.mag.studycase.configuration;

import com.mag.studycase.cache.CacheService;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@EnableCaching
public class CachingConfiguration {

    private final static String CACHE_NAME = "studycase";

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(List.of(
                new ConcurrentMapCache(CACHE_NAME)));
        return cacheManager;
    }

    @Bean
    public Cache cache() {
        return cacheManager().getCache(CACHE_NAME);
    }

}
