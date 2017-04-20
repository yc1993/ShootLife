package com.syrs.web.Model;


import java.sql.Date;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

//主页图片展示的model，对应list表
@Entity
@Component
public class MainImgShowModel {
	private Integer id;		
	private String path;
	private String title;
	private Integer imgNum;
	private Date createTime;
	private String imgName;
	private Integer manhuaNum;		//特殊漫画表的字段
	
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getImgNum() {
		return imgNum;
	}
	public void setImgNum(Integer imgNum) {
		this.imgNum = imgNum;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getManhuaNum() {
		return manhuaNum;
	}
	public void setManhuaNum(Integer manhuaNum) {
		this.manhuaNum = manhuaNum;
	}
	
	
	
	
	
}
