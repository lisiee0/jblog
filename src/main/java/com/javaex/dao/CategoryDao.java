package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CategoryVo;

@Repository
public class CategoryDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	// 블로그 생성시 카테고리 초기값 설정
	public void initialSet(Map<String, String> map) {
		sqlSession.insert("category.initialSet", map);
	}
	
	
	// 카테고리 리스트 불러오기
	public List<CategoryVo> getList(String id) {
		return sqlSession.selectList("category.getList", id);
	}
	
	
	// 특정 카테고리 불러오기
	public CategoryVo getCategory(CategoryVo vo) {
		return sqlSession.selectOne("category.getCategory", vo);
	}
	
	
	// 카테고리 추가 & 추가된 카테고리 cateNo 불러오기
	public void addSelectKey(CategoryVo vo) {
		sqlSession.insert("category.addSelectKey", vo);
	}
	
	
	// 카테고리 삭제
	public int delete(CategoryVo vo) {
		return sqlSession.delete("category.delete", vo);
	}
	
	
	

}
