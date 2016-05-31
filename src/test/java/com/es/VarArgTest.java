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
    public void testAutoEmptyVararg() {
        assertTrue(service.autoKeyMethod(10L));
    }

    @Test
    public void testAutoSingleVararg() {
        assertTrue(service.autoKeyMethod(10L, "1"));
    }

    @Test
    public void testAutoMultipleVararg() {
        assertTrue(service.autoKeyMethod(10L, "1", "2"));
    }

    @Test
    public void testAutoNullVararg() {
        assertTrue(service.autoKeyMethod(10L, null));
    }


    @Test
    public void testKeyEmptyVararg() {
        assertTrue(service.definedKeyMethod(10L));
    }

    @Test
    public void testKeySingleVararg() {
        assertTrue(service.definedKeyMethod(10L, "1"));
    }

    @Test
    public void testKeyMultipleVararg() {
        assertTrue(service.definedKeyMethod(10L, "1", "2"));
    }

    @Test
    public void testKeyNullVararg() {
        assertTrue(service.definedKeyMethod(10L, null));
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
