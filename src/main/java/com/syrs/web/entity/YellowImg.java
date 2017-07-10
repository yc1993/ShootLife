package com.syrs.web.entity;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Entity
@Component
public class YellowImg {
	private int Id;
	private int YellowListId;
	private String ImgName;
	private String Path;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getYellowListId() {
		return YellowListId;
	}
	public void setYellowListId(int yellowListId) {
		YellowListId = yellowListId;
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
	@Override
	public String toString() {
		return "YellowImg [Id=" + Id + ", YellowListId=" + YellowListId + ", ImgName=" + ImgName + ", Path=" + Path
				+ "]";
	}
	
	
}
