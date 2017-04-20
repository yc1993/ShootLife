package com.syrs.web.Model;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Entity
@Component
public class TargetModel {
	private String target;	//菜单栏的选择内容
	private String clazz;	//菜单栏的class
	private String id;		//菜单栏的id
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
