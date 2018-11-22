/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.example.springbootservice.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.springbootcommon.httpclient.HttpService;
import com.example.springbootservice.FileService;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * TODO: 请添加描述
 *
 * @author lixiang
 * @date 2018/8/2
 * @since 1.0.0
 */
@Service


public class FileServiceImpl implements FileService {

    public  String fileUpload(File file) {
        String str = HttpService.uploadFile(file, "http://upload.anhouse.cn/upload/secret.html", null);
        JSONObject js = JSONObject.parseObject(str);
        String strFileData = js.getString("filedata");
        String fileUrl = "";
        if (strFileData.contains("{") && strFileData.contains("}")) {
            JSONObject js1 = JSONObject.parseObject(strFileData);
            String sKey = js1.getString("sKey");
            String sExt = js1.getString("sExt");
            fileUrl = sKey + "." + sExt;
        }
        return fileUrl;
    }
}
