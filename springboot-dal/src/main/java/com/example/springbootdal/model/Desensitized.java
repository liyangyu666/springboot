/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.example.springbootdal.model;

import com.example.springbootcommon.enums.SensitiveTypeEnum;

import java.lang.annotation.*;

/**
 * TODO: 请添加描述
 *
 * @author lixiang
 * @date 2018/10/26
 * @since 1.0.0
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Desensitized {
    /*脱敏类型(规则)*/
    SensitiveTypeEnum type();
    /*判断注解是否生效的方法*/
    String isEffictiveMethod() default "";
}
