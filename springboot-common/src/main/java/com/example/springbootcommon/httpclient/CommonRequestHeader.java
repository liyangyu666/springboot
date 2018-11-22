

/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.example.springbootcommon.httpclient;

import lombok.Data;

@Data
public class CommonRequestHeader {
    private String requestId;
    private String requestTime;
    private String sign;
    private String token;
}
