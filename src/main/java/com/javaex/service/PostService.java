package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.dao.CategoryDao;
import com.javaex.dao.PostDao;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.PostVo;

@Service
public class PostService {
	
	@Autowired
	private PostDao pd;
	@Autowired
	private CategoryDao cd;
	
	
	// 카테고리 리스트 불러오기
	public List<CategoryVo> getList(String id) {
		return cd.getList(id);
	}
	
	
	// 글작성
	public void write(PostVo vo) {
		pd.write(vo);
	}
	
	
}
