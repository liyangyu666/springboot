/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.example.springbootdal.dao;

import com.example.springbootdal.model.UserInfo;

/**
 * 
 * UserInfoMapper数据库操作接口类
 * 
 **/

public interface UserInfoMapper{

    UserInfo selectByPrimaryKey(Long id);

}