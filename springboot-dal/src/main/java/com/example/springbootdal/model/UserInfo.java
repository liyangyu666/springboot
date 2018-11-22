/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.example.springbootdal.model;

import com.example.springbootcommon.enums.SensitiveTypeEnum;

import java.io.Serializable;

/**
 * 
 * 用户信息表
 * 
 **/
public class UserInfo implements Serializable{

	/**主键ID**/
	private Long id;

	/**姓名**/
	@Desensitized(type = SensitiveTypeEnum.CHINESE_NAME)
	private String name;

	/**性别**/
	private String sex;

	/**年龄**/
	private Integer age;

	/**身份证号**/
	@Desensitized(type = SensitiveTypeEnum.ID_CARD)
	private String cardNo;

	/**手机号**/
	@Desensitized(type = SensitiveTypeEnum.MOBILE_PHONE)
	private String mobile;



	public void setId(Long id){
		this.id=id;
	}

	public Long getId(){
		return this.id;
	}

	public void setName(String name){
		this.name=name;
	}

	public String getName(){
		return this.name;
	}

	public void setSex(String sex){
		this.sex=sex;
	}

	public String getSex(){
		return this.sex;
	}

	public void setAge(Integer age){
		this.age=age;
	}

	public Integer getAge(){
		return this.age;
	}

	public void setCardNo(String cardNo){
		this.cardNo=cardNo;
	}

	public String getCardNo(){
		return this.cardNo;
	}

	public void setMobile(String mobile){
		this.mobile=mobile;
	}

	public String getMobile(){
		return this.mobile;
	}

}
