/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.example.springbootapi.controller;

import com.example.springbootdal.model.Email;
import com.example.springbootservice.impl.MailServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO: 请添加描述
 *
 * @author lixiang
 * @date 2018/11/13
 * @since 1.0.0
 */
@RestController
public class MailController {

    @Resource
    MailServiceImpl mailService;

    @GetMapping("/send")
    public String send() throws Exception {
        //建立邮件消息
        Email mail = new Email();
        //接收者
        mail.setEmail("602954937@qq.com");
        //发送的标题
        mail.setSubject("嗨天天喽");
        //发送的内容
        mail.setContent("hello worlduuuuuu");
        mailService.send(mail);
        return "10000";
    }

    @GetMapping("/sendHtml")
    public String sendHtml() throws Exception {
        //建立邮件消息
        Email mail = new Email();
        //接收者
        mail.setEmail("602954937@qq.com");
        //发送的标题
        mail.setSubject("嗨喽00000");
        //发送的内容
        mail.setContent("hello world 哦哦哦哦");
        mailService.sendHtml(mail);
        return "10000";
    }
}
