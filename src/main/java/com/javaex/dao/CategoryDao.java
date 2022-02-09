package com.javaex.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	// 블로그 생성시 카테고리 초기값 설정
	public void initialSet(Map<String, String> map) {
		sqlSession.insert("category.initialSet", map);
	}

}
