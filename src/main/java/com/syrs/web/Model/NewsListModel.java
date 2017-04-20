package com.syrs.web.Model;

import java.sql.Timestamp;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Entity
@Component
public class NewsListModel {
	private Integer id;
	private String imgPath;
	private String title;
	private Integer num;   //表示所有新闻的count（包括内容和图片）
	private Integer coodUum;
	private Integer badNum;
	private Integer lookNum;
	private Timestamp createTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer getCoodUum() {
		return coodUum;
	}
	public void setCoodUum(Integer coodUum) {
		this.coodUum = coodUum;
	}
	public Integer getBadNum() {
		return badNum;
	}
	public void setBadNum(Integer badNum) {
		this.badNum = badNum;
	}
	public Integer getLookNum() {
		return lookNum;
	}
	public void setLookNum(Integer lookNum) {
		this.lookNum = lookNum;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
}
