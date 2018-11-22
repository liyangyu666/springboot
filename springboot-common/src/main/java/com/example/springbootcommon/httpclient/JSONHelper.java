/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.example.springbootcommon.httpclient;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @Title: JSON格式处理类
 * @Description: 将List数据集转成JSON字符串
 * @Team: 技术1部Java开发小组
 * @Author Andy-ZhichengYuan
 * @Date 2014年12月12日
 * @Version V1.0   */
public class JSONHelper {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(JSONHelper.class);

    /** Object对象转JSON字符串  */
    public static String obj2JSONString(Object obj) {
        if (obj == null) {
            return "";
        }
        return JSON.toJSONString( obj );
    }

    /** 数组/列表对象转JSON字符串  */
    public static String obj2JSONArray(Object o) {
        if (o == null)
            return "[]";// [{}]
        return JSONArray.toJSONString(o);
    }
    ////////////////////////////////////////////////////////

    /**
     * 把JSON格式的字符串转换成对象
     * @param json 字符串
     * @param
     * @return Object */
    public static <T> T jsonToObject(String json, Class<T> clazz) {
        try {
            // JSONObject jsonObj = JSONObject.parseObject( json );
            // return JSONObject.toJavaObject(jsonObj, clazz);
            return JSONObject.parseObject(json, clazz);
        } catch (Exception e) {
            LOGGER.error("转换失败", e);
            return null;
        }
    }

    /**
     * 把JSON格式的字符串转换成集合
     * @param json 字符串
     * @param clazz 集合中存放的对象的class
     * @return List */
    public static <T> List<T> jsonToList(String json, Class<T> clazz) {
        List<T> list = null;
        try {
            list = JSONArray.parseArray(json, clazz);
        } catch (Exception e) {
            LOGGER.error("转换失败", e);
            list = null;
        }
        if (list == null) {
            try {
                list = JSONObject.parseArray(json, clazz);
            } catch (Exception e) {
                LOGGER.error("转换失败", e);
                list = null;
            }
        }
        return list;
    }

    /**
     * 
    * @Title: JsonToMap 
    * @Description: TODO(解析第一层JSONObject中的key和对应的VALUE，并把对应的key和value放到Map中，并返回Map对象) 
    * @param jsonObject
    * @return
    * @throws
     */
    public static Map<String, String> JsonToMap(JSONObject jsonObject) {
        Map<String, String> result = new HashMap<String, String>();
        Set<String> iterator = jsonObject.keySet();
        String value = null;
        for (String key : iterator) {
            value = jsonObject.getString(key);
            result.put(key, value);
        }
        return result;
    }
    
    /**
     * 
     * @Title: JsonToMap 
     * @Description: TODO(解析第一层JSONObject中的key和对应的VALUE，并把对应的key和value放到Map中，并返回Map对象) 
     * @param jsonObject
     * @return
     * @throws
     */
    public static TreeMap<String, String> JsonToTreeMap(JSONObject jsonObject) {
        TreeMap<String, String> result = new TreeMap<String, String>();
        Set<String> iterator = jsonObject.keySet();
        String value = null;
        for (String key : iterator) {
            value = jsonObject.getString(key);
            result.put(key, value);
        }
        return result;
    }
    
    /**
     * 
    * @Title: JsonToMap 
    * @Description: TODO(解析第一层JSONObject中的key和对应的VALUE，并把对应的key和value放到Map中，并返回Map对象) 
    * @param jsonObject
    * @return
    * @throws
     */
    public static Map<String, Object> JsonToObMap(JSONObject jsonObject) {
        Map<String, Object> result = new HashMap<String, Object>();
        Set<String> iterator = jsonObject.keySet();
        Object value = null;
        for (String key : iterator) {
            value = jsonObject.get(key);
            result.put(key, value);
        }
        return result;
    }
}