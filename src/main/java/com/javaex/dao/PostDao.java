package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PostVo;

@Repository
public class PostDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	// 글작성
	public void write(PostVo vo) {
		sqlSession.insert("post.write", vo);
	}
	
	
	// 글 리스트 불러오기
	public List<PostVo> getList(Map<String, Object> map) {
		return sqlSession.selectList("post.getList", map);
	}
}
