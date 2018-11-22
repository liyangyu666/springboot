/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.example.springbootservice;

/**
 * TODO: 请添加描述
 *
 * @author lixiang
 * @date 2018/11/12
 * @since 1.0.0
 */
public class ThreadImplenment implements Runnable{

    public int num = 0;

    @Override
    public void run() {
        for (int i=0;i<1000000;i++){
        }
        System.out.println(Thread.currentThread().getName() + "thread start;num=" +num);

    }
}
