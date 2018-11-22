/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.example.springbootservice;

import com.example.springbootdal.model.Email;

/**
 * TODO: 请添加描述
 *
 * @author lixiang
 * @date 2018/11/14
 * @since 1.0.0
 */
public interface IMailService {

    void send(Email email) throws Exception ;

    void sendHtml(Email email) throws Exception ;

    void sendFreemarker(Email email) throws Exception ;

    void sendThymeleaf(Email email) throws Exception ;
}
