/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.example.springbootapi.controller;

/**
 * Created by ex-lixiang004 on 2018/7/27
 */


import com.alibaba.fastjson.TypeReference;
import com.example.springbootcommon.util.Base64Utils;
import com.example.springbootcommon.util.RedisClientUtil;
import com.example.springbootdal.dao.UserInfoMapper;
import com.example.springbootdal.model.UserInfo;
import com.example.springbootservice.FileService;
import com.example.springbootservice.ThreadService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


@Controller
@Slf4j
public class Example {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Resource
    private RedisClientUtil redisClientUtil;

    @Resource
    private FileService fileService;

    @Resource
    private ThreadService threadService;

    @RequestMapping("/test")
    public String home(Long id) {
        return userInfoMapper.selectByPrimaryKey(id).getName();
    }

    @RequestMapping("/cacheUserInfo")
    public String cacheUserInfo(){
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(1l);
        redisClientUtil.set(userInfo.getName(),userInfo);
        UserInfo userInfo1 = redisClientUtil.get(userInfo.getName(),new TypeReference<UserInfo>(){});
        System.err.println("======="+userInfo1.getMobile()+userInfo1.getCardNo()+userInfo.getCardNo());
        return userInfo1.getMobile()+userInfo1.getCardNo()+userInfo.getCardNo();
    }

    /*
     * 获取file.html页面
     */
    @RequestMapping("file")
    public String file(){
        return "file";
    }

    /*
     * multifile.html页面
     */
    @RequestMapping("multifile")
    public String multifile(){
        return "multifile";
    }

    /**
     * 实现文件上传
     * */
    @RequestMapping("fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam(value = "fileName") MultipartFile multipartfile){
        if(multipartfile.isEmpty()){
            return "false";
        }
        String fileName = multipartfile.getOriginalFilename();
        log.info("fileName:{}",fileName);
        CommonsMultipartFile commonsmultipartfile = (CommonsMultipartFile) multipartfile;
        DiskFileItem diskFileItem = (DiskFileItem) commonsmultipartfile.getFileItem();
        File file = diskFileItem.getStoreLocation();
        log.info("转换之后的文件:{}",file);
        fileService.fileUpload(file);
        return null;
    }

    @RequestMapping("fileDownload")
    @ResponseBody
    public String fileDownload(HttpServletResponse response){
        String imageKey = "c42f36a8c3463e7c13b845938207d8e2316d2efa.jpg";
        log.info("图片值:{},",imageKey);
        String sendPushUrl = "";
        try {
            sendPushUrl = "http://dfs.d.pa.com/interface/view/secret/" + imageKey;
            URL url = new URL(sendPushUrl);
            URLConnection conn = url.openConnection();
            InputStream inStream = conn.getInputStream();
            String picExt = StringUtils.substringAfterLast(imageKey,".");
            //设置返回的文件类型
            response.setContentType("image/" + picExt);
            //设置该图片允许跨域访问
            response.setHeader("Access-Control-Allow-Origin", "*");
            IOUtils.copy(inStream, response.getOutputStream());
        } catch (MalformedURLException e) {
            log.error("图片路径非法，加载失败：" + sendPushUrl, e);
        } catch (IOException e) {
            log.error("图片读写错误：" + sendPushUrl, e);
        } catch (Exception e) {
            log.error("图片加载错误：" + sendPushUrl, e);
        }
        return null;
    }


    /**
     * 实现文件上传
     * */
    @RequestMapping(value = "/stringUpload", method = RequestMethod.POST)
    @ResponseBody
    public String stringUpload(HttpServletRequest request, @RequestParam(value = "base64String", defaultValue = "") String base64String){
        System.err.println(request.getParameter("base64String"));
        System.err.println(base64String.length());
        String contextPath = "/Users/lixiang/lixiang/test.jpg";
        Base64Utils.Base64ToImage(base64String,contextPath);
        File file = new File(contextPath);
        log.info("转换之后的文件:{}",file);
        fileService.fileUpload(file);
        return null;
    }

    /*
     * threadTest
     */
    @RequestMapping("/threadTest")
    @ResponseBody
    public String threadTest(){
        threadService.testThread();
        return "test";
    }

}