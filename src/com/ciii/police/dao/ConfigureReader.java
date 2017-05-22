package com.ciii.police.dao;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * 配置文件读取器
 * 
 */
public class ConfigureReader {
	private String url; // 配置文件路径
	private Configuration config; // 配置对象

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public ConfigureReader() {
		this.url = "";
	}
	
	public Configuration getConfig() {
		return config;
	}

	public void setConfig(Configuration config) {
		this.config = config;
	}

	/**
	 * 初始化配置文件读取器
	 * @param url
	 */
	public ConfigureReader(String url) {
		this.url = url;
		try {
			config = new PropertiesConfiguration(url);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * 获取配置文件中的Key值
	 * @param name
	 * @return
	 */
	public String getValue(String name) {
		String value = "";
		value = config.getString(name);
		return value;
	}	
}