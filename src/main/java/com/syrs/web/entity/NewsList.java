package com.syrs.web.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Entity
@Component
public class NewsList {
	private int id;
	private String title;
	private String imgPath;
	private int num;
	private int goodNum;
	private int badNum;
	private int lookNum;
	private Timestamp createTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getGoodNum() {
		return goodNum;
	}
	public void setGoodNum(int goodNum) {
		this.goodNum = goodNum;
	}
	public int getBadNum() {
		return badNum;
	}
	public void setBadNum(int badNum) {
		this.badNum = badNum;
	}
	public int getLookNum() {
		return lookNum;
	}
	public void setLookNum(int lookNum) {
		this.lookNum = lookNum;
	}
	
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreatTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "NewsList [id=" + id + ", title=" + title + ", imgPath=" + imgPath + ", num=" + num + ", goodNum="
				+ goodNum + ", badNum=" + badNum + ", lookNum=" + lookNum + ", creatTime=" + createTime + "]";
	}
	
	
}
