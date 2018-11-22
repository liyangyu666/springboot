/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.example.springbootservice.impl;


import com.example.springbootdal.dao.UserInfoMapper;
import com.example.springbootdal.model.UserInfo;
import com.example.springbootservice.UserInfoService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * TODO: 请添加描述
 *
 * @author lixiang
 * @date 2018/8/1
 * @since 1.0.0
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public UserInfo getUserIno() {
        return userInfoMapper.selectByPrimaryKey(1l);
    }
}
