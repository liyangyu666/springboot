/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.example.springbootservice.impl;

import com.example.springbootdal.model.Email;
import com.example.springbootservice.IMailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * TODO: 请添加描述
 *
 * @author lixiang
 * @date 2018/11/14
 * @since 1.0.0
 */
@Slf4j
@Service
public class MailServiceImpl implements IMailService {
    @Autowired
    private JavaMailSender mailSender;//执行者

    /*@Autowired
    public Configuration configuration;//freemarker*/

    @Autowired
    private SpringTemplateEngine templateEngine;//thymeleaf

    @Value("${spring.mail.username}")
    public String USER_NAME;//发送者

    @Override
    public void send(Email mail) throws Exception {
        log.info("发送邮件：{}",mail.getContent());
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(USER_NAME);
        message.setTo(mail.getEmail());
        message.setSubject(mail.getSubject());
        message.setText(mail.getContent());
        mailSender.send(message);
    }

    @Override
    public void sendHtml(Email mail) throws Exception {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        //这里可以自定义发信名称比如：爪哇笔记
        helper.setFrom(USER_NAME,"3434");
        helper.setTo(mail.getEmail());
        helper.setSubject(mail.getSubject());
        helper.setText(
                "<html><body><img src=\"cid:springcloud\" ></body></html>",
                true);
        // 发送图片
        File file = ResourceUtils.getFile("/Users/lixiang/lixiang/test.jpg");
        helper.addInline("springcloud", file);
        // 发送附件
        file = ResourceUtils.getFile("/Users/lixiang/Downloads/蛋壳20181024.xlsx");
        helper.addAttachment("百度", file);
        mailSender.send(message);
    }

    @Override
    public void sendFreemarker(Email mail) throws Exception {
        /*MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        //这里可以自定义发信名称比如：爪哇笔记
        helper.setFrom(USER_NAME,"爪哇笔记");
        helper.setTo(mail.getEmail());
        helper.setSubject(mail.getSubject());
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("mail", mail);
        model.put("path", PATH);
        Template template = configuration.getTemplate(mail.getTemplate());
        String text = FreeMarkerTemplateUtils.processTemplateIntoString(
                template, model);
        helper.setText(text, true);
        mailSender.send(message);
        mail.setContent(text);
        OaEmail oaEmail = new OaEmail(mail);
        mailRepository.save(oaEmail);*/
    }

    @Override
    public void sendThymeleaf(Email mail) throws Exception {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(USER_NAME);
        helper.setTo(mail.getEmail());
        helper.setSubject(mail.getSubject());
        Context context = new Context();
        context.setVariable("email", mail);
        String text = templateEngine.process(mail.getTemplate(), context);
        helper.setText(text, true);
        mailSender.send(message);
    }
}
