package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.CategoryService;
import com.javaex.vo.CategoryVo;

@Controller
@RequestMapping("/{id}/admin/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	// 카테고리 리스트 & 관리
	@RequestMapping("")
	public String main() {
		System.out.println("cateController/main()");
		
		return "/blog/admin/blog-admin-cate";
	}
	
	
	// 카테고리 리스트 불러오기
	@ResponseBody
	@RequestMapping("/list")
	public List<CategoryVo> list(@PathVariable("id") String id) {
		System.out.println("cateController/categoryList()");

		return categoryService.getList(id);
	}
	
	
	// 카테고리 추가
	@ResponseBody
	@RequestMapping("/add")
	public CategoryVo add(@ModelAttribute CategoryVo vo) {
		System.out.println("cateController/add()");
		
		return categoryService.add(vo);
	}
	
	
	// 카테고리 삭제
	@ResponseBody
	@RequestMapping("/delete")
	public String delete(@ModelAttribute CategoryVo vo) {
		System.out.println("cateController/delete()");
		
		return categoryService.delete(vo);
	}

}
