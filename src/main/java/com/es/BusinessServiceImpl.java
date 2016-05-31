package com.es;

import org.springframework.cache.annotation.Cacheable;

public class BusinessServiceImpl implements BusinessService {

    @Cacheable(value = "cache", key = "#id")
    public boolean businessMethod(Long id, String... args) {
        return true;
    }
}
