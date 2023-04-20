package com.redis.demo.service;

import com.redis.demo.entity.T1;
import com.redis.demo.mapper.T1Mapper;

/**
 * TODO
 *
 * @author Pangdb
 */
public class MyThread implements Runnable {

    Integer i;
    T1Mapper mapper;

    public MyThread(Integer i, T1Mapper mapper) {
        this.i = i;
        this.mapper = mapper;
    }

    @Override
    public void run() {
        for (int j = 0; j < 1000; j++) {
            T1 t1 = new T1();

            i += j;

            t1.setName("name_" + i);

            t1.setS1((byte) ((i + (int) (1 + Math.random() * 10)) % 2));
            t1.setS2((byte) ((i + (int) (1 + Math.random() * 10)) % 2));
            t1.setS3((byte) ((i + (int) (1 + Math.random() * 10)) % 2));
            t1.setS4((byte) ((i + (int) (1 + Math.random() * 10)) % 2));
            mapper.insert(t1);
        }

    }
}