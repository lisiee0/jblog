package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.CategoryDao;
import com.javaex.vo.CategoryVo;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryDao cd;
	
	
	// 카테고리 리스트 불러오기
	public List<CategoryVo> getList(String id) {
		return cd.getList(id);
	}
	
	
	// 카테고리 추가 & 추가된 카테고리 불러오기
	public CategoryVo add(CategoryVo vo) {
		cd.addSelectKey(vo);
		return cd.getCategory(vo);
	}
	
	
	// 카테고리 삭제
	public String delete(CategoryVo vo) {
		int count= cd.delete(vo);
		
		if (count>0) {
			return "success";
		}
		else {
			return "fail";
		}
	}

}
