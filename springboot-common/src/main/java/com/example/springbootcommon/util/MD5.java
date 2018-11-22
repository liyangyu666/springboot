/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.example.springbootcommon.util;

import java.security.MessageDigest;

/**
 * TODO: 请添加描述
 *
 * @author ex-WANGZHAO926
 * @date 2018-06-13
 * @since 1.0.0
 */
public final class MD5 {

    /**
     * 获取MD5加密后的字符串
     * @param str 明文
     * @return 加密后的字符串
     * @throws Exception
     */
    public static String getMD5(String str) throws Exception {
        /** 创建MD5加密对象 */
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        /** 进行加密 */
        md5.update(str.getBytes());
        /** 获取加密后的字节数组 */
        byte[] md5Bytes = md5.digest();
        String res = "";
        for (int i = 0; i < md5Bytes.length; i++){
            int temp = md5Bytes[i] & 0xFF;
            if (temp <= 0XF){
                // 转化成十六进制不够两位，前面加零
                res += "0";
            }
            res += Integer.toHexString(temp);
        }
        return res;
    }
}

