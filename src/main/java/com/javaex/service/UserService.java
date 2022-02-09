package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao ud;
	
	
	// 회원가입
	public void join(UserVo vo) {
		ud.join(vo);
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
