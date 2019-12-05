package com.briup.bean;

/**
 * 
    * @ClassName: Skin
    * @Description: bean对象 封装英雄皮肤信息
    * @author y2312
    * @date Dec 5, 2019
    *
 */
public class Skin {

	private String id;
	private String num;
	private String name;
	private String chromas;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getChromas() {
		return chromas;
	}

	public void setChromas(String chromas) {
		this.chromas = chromas;
	}

}
