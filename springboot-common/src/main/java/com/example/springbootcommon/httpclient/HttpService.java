/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.example.springbootcommon.httpclient;

import org.apache.commons.httpclient.Header;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/**
 * @author EX-HUYAOYUAN700
 * @ClassName: HttpServiceImpl
 * @Description: http包装类实现
 * @date 2016年11月16日 上午10:46:40
 */
public class HttpService {

    public static String postRequestResponseBodyAsString(String url,
                                                         Map<String, String> parameters) throws RuntimeException {
        return HttpHelper.postRequestResponseBodyAsString(url, parameters);
    }


    public static String postRequestResponseBodyAsString(String url,
                                                         Map<String, String> parameters, Integer contimeout,
                                                         Integer sotimeout) throws RuntimeException {
        return HttpHelper.postRequestResponseBodyAsString(null, url, parameters,
                contimeout, sotimeout);
    }


    public static String postRequestResponseBodyAsString(String url, String str)
            throws RuntimeException {
        return HttpHelper.postRequestResponseBodyAsString(url, str);
    }


    public static String postRequestResponseBodyAsString(String url, String str,
                                                         Integer contimeout, Integer sotimeout) throws RuntimeException {
        return HttpHelper.postRequestResponseBodyAsString(null, url, str,
                contimeout, sotimeout);
    }


    public static String uploadFile(File file, String url, Map<String, String> map)
            throws RuntimeException {
        return HttpHelper.uploadFile(file, url, map);
    }


    public static String getRequestResponseBodyAsString(String url, Charset charset)
            throws RuntimeException {
        return HttpHelper.getRequestResponseBodyAsString(null, url, charset,
                null);
    }


    public static String getRequestResponseBodyAsString(String url, Charset charset,
                                                        Integer contimeout, Integer sotimeout) throws RuntimeException {
        return HttpHelper.getRequestResponseBodyAsString(null, url, charset,
                contimeout, sotimeout, null);
    }

    public static String postRequestResponseBodyAsString(List<Header> headerList,
                                                         String url, Map<String, String> parameters)
            throws RuntimeException {
        return HttpHelper.postRequestResponseBodyAsString(headerList, url,
                parameters);
    }

    public static String postRequestResponseBodyAsString(List<Header> headerList,
                                                         String url, Map<String, String> parameters, Integer contimeout,
                                                         Integer sotimeout) throws RuntimeException {
        return HttpHelper.postRequestResponseBodyAsString(headerList, url,
                parameters, contimeout, sotimeout);
    }

    public static String postRequestResponseBodyAsString(List<Header> headerList,
                                                         String url, String str) throws RuntimeException {
        return HttpHelper.postRequestResponseBodyAsString(headerList, url, str);
    }

    public static String postRequestResponseBodyAsString(List<Header> headerList,
                                                         String url, String str, Integer contimeout, Integer sotimeout)
            throws RuntimeException {
        return HttpHelper.postRequestResponseBodyAsString(headerList, url, str,
                contimeout, sotimeout);
    }

    public static String getFile(String url, Charset charset) {
        return HttpHelper.getFile(url, charset);
    }


    public static String getFile(String url, Charset charset, Integer contimeout, Integer sotimeout) {
        return HttpHelper.getFile(url, charset, contimeout, sotimeout);
    }
}
