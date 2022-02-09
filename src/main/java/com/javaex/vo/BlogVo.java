package com.javaex.vo;

public class BlogVo {
	
	private String blogId;
	private String blogTitle;
	private String logoFile;
	
	
	
	public BlogVo() {
		
	}
	
	public BlogVo(String blogId, String blogTitle, String logoFile) {
		this.blogId = blogId;
		this.blogTitle = blogTitle;
		this.logoFile = logoFile;
	}

	
	public String getBlogId() {
		return blogId;
	}

	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getLogoFile() {
		return logoFile;
	}

	public void setLogoFile(String logoFile) {
		this.logoFile = logoFile;
	}

	@Override
	public String toString() {
		return "BlogVo [blogId=" + blogId + ", blogTitle=" + blogTitle + ", logoFile=" + logoFile + "]";
	}
}
