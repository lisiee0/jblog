package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.PostService;
import com.javaex.vo.PostVo;

@Controller
@RequestMapping("/{id}/admin/writeForm")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	
	// 글작성 폼
	@RequestMapping("")
	public String writeForm(@PathVariable("id") String id, Model model) {
		System.out.println("postController/writeForm()");
		
		// 카테고리 리스트 불러오기
		model.addAttribute("cList", postService.getList(id));
		
		return "/blog/admin/blog-admin-write";
	}
	
	
	// 글작성
	@RequestMapping("/write")
	public String write(@ModelAttribute PostVo vo) {
		System.out.println("postController/write()");
		System.out.println(vo);
		postService.write(vo);
		
		return "redirect:/{id}/admin/writeForm";
	}
	

}
