package com.syrs.web.Model;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Entity
@Component
public class NewsContentModel {
	private String path;	//图片地址
	private Integer newsListNum;
	private Integer num;    //新闻排序作用
	private String content; //新闻内容
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Integer getNewsListNum() {
		return newsListNum;
	}
	public void setNewsListNum(Integer newsListNum) {
		this.newsListNum = newsListNum;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
