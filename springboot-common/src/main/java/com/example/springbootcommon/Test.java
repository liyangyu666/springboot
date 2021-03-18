/*
 * Copyright (C) 2021 Baidu, Inc. All Rights Reserved.
 */
package com.example.springbootcommon;

import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author lixiang
 * @date 2021/01/26 15:33
 **/
public class Test {

    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 1000, 200L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.DiscardOldestPolicy());

    public static void test2(){

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i<10;i++) {
            threadPoolExecutor.execute(()-> {
                for (int j = 0; j < 500; j++) {
                    map.put(new Integer(j), j);
                }
            });
        }
    }

    public static void main(String[] args) {
        test2();
    }
}
