package com.javaex.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	// 회원가입
	public void join(Map<String, String> map) {
		System.out.println("Dao"+map);
		sqlSession.insert("user.join", map);
	}
}
