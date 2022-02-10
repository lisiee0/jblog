package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.vo.BlogVo;

@Service
public class BlogService {
	
	@Autowired
	private BlogDao bd;

	
	
	// 블로그 정보 가져오기
	public BlogVo getBlog(String id) {
		return bd.blogInfo(id);
	}
	
	
	// 블로그 관리(기본페이지)
	

}
