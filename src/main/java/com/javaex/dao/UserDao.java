package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	// 회원가입
	public void join(UserVo vo) {
		sqlSession.insert("user.join", vo);
	}
	
	
	// 로그인
	public UserVo getUser(UserVo vo) {
		return sqlSession.selectOne("user.getUser", vo);
	}
}
