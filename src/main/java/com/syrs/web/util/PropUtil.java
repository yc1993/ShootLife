package com.syrs.web.util;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class PropUtil {
	private static PropUtil propUtil = null;
	private static Properties props;
	
	private PropUtil(){
		try {
			Resource resource = new ClassPathResource("/application.properties");
			props = new Properties();
			props.load(resource.getInputStream());
		}catch(IOException e){
			 e.printStackTrace();
	    }
	}
	
	public static PropUtil getInstance() {
		if (propUtil == null) {
			propUtil = new PropUtil();
		}
		return propUtil;
	}
	
	public static String getValue(String key){
		PropUtil.getInstance();
		return props.getProperty(key);
	}
}
