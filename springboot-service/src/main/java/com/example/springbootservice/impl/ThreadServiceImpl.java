/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.example.springbootservice.impl;

import com.example.springbootservice.ThreadImplenment;
import com.example.springbootservice.ThreadService;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * TODO: 请添加描述
 *
 * @author lixiang
 * @date 2018/11/12
 * @since 1.0.0
 */
@Service
public class ThreadServiceImpl implements ThreadService {

    @Resource
    private ThreadPoolTaskExecutor taskExecutor;

    @Override
    public void testThread() {
        for (int i = 0; i<20; i++){
            ThreadImplenment threadImplenment = new ThreadImplenment();
            threadImplenment.num=i;
            taskExecutor.execute(threadImplenment);
        }
    }
}
