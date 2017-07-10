package com.syrs.web.entity;

import java.sql.Date;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Entity
@Component
public class FaceList {
	private int Id;
	private String Title;
	private int Type;
	//图片数量
	private int ImgNum;
	private String ImgName;
	private String Path;
	private int GoodNum;
	private int BadNum;
	private int LookNum;
	private Date CreatTime;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public int getType() {
		return Type;
	}
	public void setType(int type) {
		Type = type;
	}
	public int getImgNum() {
		return ImgNum;
	}
	public void setImgNum(int imgNum) {
		ImgNum = imgNum;
	}
	public String getImgName() {
		return ImgName;
	}
	public void setImgName(String imgName) {
		ImgName = imgName;
	}
	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}
	public int getGoodNum() {
		return GoodNum;
	}
	public void setGoodNum(int goodNum) {
		GoodNum = goodNum;
	}
	public int getBadNum() {
		return BadNum;
	}
	public void setBadNum(int badNum) {
		BadNum = badNum;
	}
	public int getLookNum() {
		return LookNum;
	}
	public void setLookNum(int lookNum) {
		LookNum = lookNum;
	}
	public Date getCreatTime() {
		return CreatTime;
	}
	public void setCreatTime(Date creatTime) {
		CreatTime = creatTime;
	}
	@Override
	public String toString() {
		return "FaceList [Id=" + Id + ", Title=" + Title + ", Type=" + Type + ", ImgNum=" + ImgNum + ", ImgName="
				+ ImgName + ", Path=" + Path + ", GoodNum=" + GoodNum + ", BadNum=" + BadNum + ", LookNum=" + LookNum
				+ ", CreatTime=" + CreatTime + "]";
	}
	
	
	
}
