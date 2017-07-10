package com.syrs.web.entity;

import java.sql.Date;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Entity
@Component
public class ManhuaList {
	private int Id;
	private String Title;
	private int Type;
	private String Content;
	private int num;//一共几话
	private String ImgName;
	private String Path;
	private int GoodNum;
	private int BadNum;
	private int LookNum;
	private Date CreatTime;
	private int index;//标记当前第几话
	
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
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	@Override
	public String toString() {
		return "ManhuaList [Id=" + Id + ", Title=" + Title + ", Type=" + Type + ", Content=" + Content + ", num=" + num
				+ ", ImgName=" + ImgName + ", Path=" + Path + ", GoodNum=" + GoodNum + ", BadNum=" + BadNum
				+ ", LookNum=" + LookNum + ", CreatTime=" + CreatTime + ", index=" + index + "]";
	}


	
	
	
}
