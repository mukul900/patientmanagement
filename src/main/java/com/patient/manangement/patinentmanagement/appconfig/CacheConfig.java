package com.patient.manangement.patinentmanagement.appconfig;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableCaching
@Configuration
public class CacheConfig {
    @Bean
    public CacheManager cacheManager(){
        return new org.springframework.cache.support.SimpleCacheManager();
    }
}
