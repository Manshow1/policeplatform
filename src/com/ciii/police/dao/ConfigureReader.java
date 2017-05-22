package com.ciii.police.dao;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * �����ļ���ȡ��
 * 
 */
public class ConfigureReader {
	private String url; // �����ļ�·��
	private Configuration config; // ���ö���

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
	 * ��ʼ�������ļ���ȡ��
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
	 * ��ȡ�����ļ��е�Keyֵ
	 * @param name
	 * @return
	 */
	public String getValue(String name) {
		String value = "";
		value = config.getString(name);
		return value;
	}	
}