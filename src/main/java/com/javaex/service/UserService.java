package com.javaex.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.dao.CategoryDao;
import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao ud;
	@Autowired
	private BlogDao bd;
	@Autowired
	private CategoryDao cd;
	
	// 회원가입
	public void join(UserVo vo) {
		ud.join(vo);
		
		// 회원가입시 블로그 자동생성
		Map<String, String> bMap= new HashMap<String, String>();
		bMap.put("blogId", vo.getId());
		bMap.put("blogTitle", vo.getUserName()+"의 블로그입니다.");
		bMap.put("logoFile", "");
		bd.blogCreate(bMap);
		
		// 블로그 생성시 카테고리 기본값
		Map<String, String> cMap= new HashMap<String, String>();
		cMap.put("id", vo.getId());
		cMap.put("cateName", "미분류");
		cMap.put("description", "기본으로 만들어지는 카테고리 입니다.");
		cd.initialSet(cMap);
	}
	
	
	// 로그인
	public UserVo login(UserVo vo) {
		return ud.getUser(vo);
	}
	
	
	// 아이디 중복체크
	public String checkDup(UserVo vo) {
		int count= ud.checkDup(vo);
		
		if(count>0) {
			return "inuse";
		}
		else {
			return "available";
		}
	}
}
