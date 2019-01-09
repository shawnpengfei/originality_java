package com.ssy.app.vo;

import java.util.List;


/**
* Copyright: Copyright (c) 2018 
* @author: taoge
* @version: v1.0.0
* @date: 2018年12月20日 上午11:44:21
* @ClassName: PageBeanVo.java
*/
public class PageBeanVo<T> {

	private int code;
	private int count;
	private String msg;
	private List<T> data;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	
	public static <T> PageBeanVo setPage(int count,List<T> data) {
		PageBeanVo pvo=new PageBeanVo();
		pvo.setCode(0);
		pvo.setMsg("ok");
		pvo.setCount(count);
		pvo.setData(data);
		return pvo;
	}
}
