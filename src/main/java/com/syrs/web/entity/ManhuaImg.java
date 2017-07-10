package com.syrs.web.entity;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Entity
@Component
public class ManhuaImg {
	private int Id;
	private int ManhuaListId;
	private int Num;//第几张图片
	private String ImgName;
	private String Path;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getManhuaListId() {
		return ManhuaListId;
	}
	public void setManhuaListId(int manhuaListId) {
		ManhuaListId = manhuaListId;
	}
	public int getNum() {
		return Num;
	}
	public void setNum(int num) {
		Num = num;
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
		return "ManhuaImg [Id=" + Id + ", ManhuaListId=" + ManhuaListId + ", Num=" + Num + ", ImgName=" + ImgName
				+ ", Path=" + Path + "]";
	}
	
	
}
