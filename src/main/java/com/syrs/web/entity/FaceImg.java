package com.syrs.web.entity;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Entity
@Component
public class FaceImg {
	private int Id;
	private int FaceListId;
	private String ImgName;
	private String Path;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getFaceListId() {
		return FaceListId;
	}
	public void setFaceListId(int faceListId) {
		FaceListId = faceListId;
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
		return "FaceImg [Id=" + Id + ", FaceListId=" + FaceListId + ", ImgName=" + ImgName + ", Path=" + Path + "]";
	}
	
	
}
