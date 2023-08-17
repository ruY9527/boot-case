package com.yang.dubbo.common.entity;


import java.io.Serializable;

/**
 * @program: Dubbo_NZ1906
 * @description:
 * @author: Feri
 * @create: 2020-02-11 11:44
 */
public class Student implements Serializable {
    private String no;
    private String name;
    private String address;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
    
    
}
