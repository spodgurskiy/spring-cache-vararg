package com.es;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = VarArgTest.TestContext.class)
public class VarArgTest {
    @Autowired
    private BusinessService service;

    @Test
    public void testEmptyVararg() {
        assertTrue(service.businessMethod(10L));
    }

    @Test
    public void testSingleVararg() {
        assertTrue(service.businessMethod(10L, "1"));
    }

    @Test
    public void testMultipleVararg() {
        assertTrue(service.businessMethod(10L, "1", "2"));
    }

    @Test
    public void testNullVararg() {
        assertTrue(service.businessMethod(10L, null));
    }

    @Configuration
    @EnableCaching
    public static class TestContext {

        @Bean
        public CacheManager cacheManager() {
            SimpleCacheManager cacheManager = new SimpleCacheManager();
            cacheManager.setCaches(Collections.singletonList(new ConcurrentMapCache("cache")));
            return cacheManager;
        }

        @Bean
        public BusinessService service() {
            return new BusinessServiceImpl();
        }
    }
}
