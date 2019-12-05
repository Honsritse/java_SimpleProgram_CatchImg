package com.briup.bean;

import java.util.Map;

/**
 * 
    * @ClassName: ChampionsInfo
    * @Description: bean对象 用以封装从地址获取到的所有英雄信息
    * @author y2312
    * @date Dec 5, 2019
    *
 */


public class ChampionsInfo {

	private String type;
	private String format;
	private String version;
	private Map<String, HeroAndSkins> data;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Map<String, HeroAndSkins> getData() {
		return data;
	}

	public void setData(Map<String, HeroAndSkins> data) {
		this.data = data;
	}

}
