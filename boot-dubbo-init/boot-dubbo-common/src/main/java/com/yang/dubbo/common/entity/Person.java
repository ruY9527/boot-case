package com.yang.dubbo.common.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * @program: Dubbo_NZ1906
 * @description:
 * @author: Feri
 * @create: 2020-02-11 16:09
 */
public class Person implements Serializable {
    private Integer id;
    private String name;
    private String info;
    private String address;
    private Date stime;
    private Date etime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getStime() {
		return stime;
	}
	public void setStime(Date stime) {
		this.stime = stime;
	}
	public Date getEtime() {
		return etime;
	}
	public void setEtime(Date etime) {
		this.etime = etime;
	}
    
    
    
}