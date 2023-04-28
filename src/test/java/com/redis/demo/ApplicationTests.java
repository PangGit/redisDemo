package com.redis.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

@SpringBootTest
class ApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("----test----");
    }

    @Test
    void redisPut() {
        StopWatch sw = new StopWatch("test");
        sw.start();

        long count = 0L;
        for (int i = 0; i < 1000_000_000; i++) {
            count += i;
        }
        System.out.println("count :" + count);

        sw.stop();
    }

    @Test
    void redisGet() {

    }

    @Test
    void cache() {

    }

}
