/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.example.springbootdal.model;

import lombok.Data;

import java.util.List;

/**
 * TODO: 请添加描述
 *
 * @author lixiang
 * @date 2018/10/26
 * @since 1.0.0
 */
@Data
public class Test {

    private List<UserInfo> userInfos;

    private Long id;
}
