package com.es;

import org.springframework.cache.annotation.Cacheable;

public class BusinessServiceImpl implements BusinessService {

    @Cacheable(value = "cache", key = "#id")
    public boolean definedKeyMethod(Long id, String... args) {
        return true;
    }

    @Cacheable(value = "cache")
    public boolean autoKeyMethod(Long id, String... args) {
        return true;
    }
}
