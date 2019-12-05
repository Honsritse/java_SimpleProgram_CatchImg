package com.briup.bean;

import java.util.List;

/**
 * 
    * @ClassName: HeroAndSkins
    * @Description: bean对象 用以封装从地址获取到的某个英雄信息
    * @author y2312
    * @date Dec 5, 2019
    *
 */

public class HeroAndSkins{

	private String version;
	private Object info;
	private Object tags;
	private String partype;
	private Object stats;
	private String id;
	private String name;
	private String key;
	private String title;
	private Object image;
	private String lore;
	private String blurb;
	private List<Skin> skins;
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Object getInfo() {
		return info;
	}
	public void setInfo(Object info) {
		this.info = info;
	}
	public Object getTags() {
		return tags;
	}
	public void setTags(Object tags) {
		this.tags = tags;
	}
	public String getPartype() {
		return partype;
	}
	public void setPartype(String partype) {
		this.partype = partype;
	}
	public Object getStats() {
		return stats;
	}
	public void setStats(Object stats) {
		this.stats = stats;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Object getImage() {
		return image;
	}
	public void setImage(Object image) {
		this.image = image;
	}
	public String getLore() {
		return lore;
	}
	public void setLore(String lore) {
		this.lore = lore;
	}
	public String getBlurb() {
		return blurb;
	}
	public void setBlurb(String blurb) {
		this.blurb = blurb;
	}
	public List<Skin> getSkins() {
		return skins;
	}
	public void setSkins(List<Skin> skins) {
		this.skins = skins;
	}

}
