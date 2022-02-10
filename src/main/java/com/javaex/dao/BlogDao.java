package com.javaex.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;

@Repository
public class BlogDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	// 블로그 자동생성(회원가입시)
	public void blogCreate(Map<String, String> map) {
		sqlSession.insert("blog.create", map);
	}
	
	
	// 블로그정보 불러오기
	public BlogVo blogInfo(String id) {
		return sqlSession.selectOne("blog.info", id);
	}
	
	
	// 블로그 기본설정변경
	public void changeSet(BlogVo vo) {
		sqlSession.update("blog.changeSet", vo); 
	}
}
