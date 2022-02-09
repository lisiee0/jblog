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
}
