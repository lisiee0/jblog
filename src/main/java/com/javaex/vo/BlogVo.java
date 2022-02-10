package com.javaex.vo;

public class BlogVo {
	
	private String blogId;
	private String blogTitle;
	private String logoFile;
	private String userName;
	
	
	public BlogVo() {
		
	}


	public BlogVo(String blogId, String blogTitle, String logoFile, String userName) {
		super();
		this.blogId = blogId;
		this.blogTitle = blogTitle;
		this.logoFile = logoFile;
		this.userName = userName;
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


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	@Override
	public String toString() {
		return "BlogVo [blogId=" + blogId + ", blogTitle=" + blogTitle + ", logoFile=" + logoFile + ", userName="
				+ userName + "]";
	}
}
	