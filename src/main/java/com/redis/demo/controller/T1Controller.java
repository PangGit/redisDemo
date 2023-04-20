package com.redis.demo.controller;

import com.redis.demo.entity.T1;
import com.redis.demo.mapper.T1Mapper;
import com.redis.demo.service.MyThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author Pangdb
 */
@RestController
public class T1Controller {

    @Autowired
    private T1Mapper mapper;

    @GetMapping("/")
    public String info() {
        return "hello";
    }

    @GetMapping("/create")
    public void create() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(6, 6,
                5, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        int i = 0;
        do {
            executor.execute(new MyThread(i, mapper));
            i += 1000;
        } while (i < 10_000);

        executor.shutdown();
        System.out.println("------end---------");
    }

    @PostMapping("/put")
    public Boolean put(@RequestBody T1 param) {
        System.out.println("----------" + param);




        return Boolean.TRUE;
    }

    @GetMapping("/get")
    public List<T1> put() {
        System.out.println("----------");


        return null;
    }

}
