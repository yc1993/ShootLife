package com.syrs.web.entity;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Entity
@Component
public class NewsListImgAndContent {
	private int Id;
	private String Path;
	private String Content;
	private int NewsListId;
	private int Num;//新闻里的第几条，第一条是0
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public int getNewsListId() {
		return NewsListId;
	}
	public void setNewsListId(int newsListId) {
		NewsListId = newsListId;
	}
	public int getNum() {
		return Num;
	}
	public void setNum(int num) {
		Num = num;
	}
	@Override
	public String toString() {
		return "NewsListImgAndContent [Id=" + Id + ", Path=" + Path + ", Content=" + Content + ", NewsListId="
				+ NewsListId + ", Num=" + Num + "]";
	}
	
	
	
}
