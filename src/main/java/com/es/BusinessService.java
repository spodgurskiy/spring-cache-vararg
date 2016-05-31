package com.es;

public interface BusinessService {

    boolean definedKeyMethod(Long id, String... args);

    boolean autoKeyMethod(Long id, String... args);
}
