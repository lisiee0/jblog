package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.CategoryService;

@Controller
@RequestMapping("/{id}/admin/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("")
	public String categoryList() {
		System.out.println("cateController/categoryList()");
		
		return "/blog/admin/blog-admin-cate";
	}
}
