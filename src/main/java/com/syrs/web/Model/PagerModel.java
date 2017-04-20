package com.syrs.web.Model;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Entity
@Component
public class PagerModel {
	private String url;
	private String showContent;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getShowContent() {
		return showContent;
	}
	public void setShowContent(String showContent) {
		this.showContent = showContent;
	}
	
	
}
