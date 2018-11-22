/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.example.springbootdal.model;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;

/**
 * TODO: 请添加描述
 *
 * @author lixiang
 * @date 2018/11/14
 * @since 1.0.0
 */
@Data
public class Email implements Serializable{

    private static final long serialVersionUID = 1L;
    //必填参数
    private String email;//接收方邮件
    private String subject;//主题
    private String content;//邮件内容
    //选填
    private String template;//模板
    private HashMap<String, String> kvMap;// 自定义参数

}
