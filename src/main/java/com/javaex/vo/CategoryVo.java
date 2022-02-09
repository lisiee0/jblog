package com.javaex.vo;

public class CategoryVo {
	
	private int cateNo;
	private int id;
	private String cateName;
	private String description;
	private String regDate;
	
	
	public CategoryVo() {
		
	}
	
	
	public CategoryVo(int cateNo, int id, String cateName, String description, String regDate) {
		this.cateNo = cateNo;
		this.id = id;
		this.cateName = cateName;
		this.description = description;
		this.regDate = regDate;
	}


	
	public int getCateNo() {
		return cateNo;
	}


	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCateName() {
		return cateName;
	}


	public void setCateName(String cateName) {
		this.cateName = cateName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getRegDate() {
		return regDate;
	}


	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}


	@Override
	public String toString() {
		return "CategoryVo [cateNo=" + cateNo + ", id=" + id + ", cateName=" + cateName + ", description=" + description
				+ ", regDate=" + regDate + "]";
	}
}
