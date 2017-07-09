package com.syrs.web.Model;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Entity
@Component
public class SecondImgAryModel {
	private Integer id;
	private String imagePath;
	private String listId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public String getListId() {
		return listId;
	}
	public void setListId(String listId) {
		this.listId = listId;
	}
	
	
	
	
}
