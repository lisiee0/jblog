package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.BlogService;
import com.javaex.vo.BlogVo;

@Controller
@RequestMapping("/{id}")
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	

	// 블로그 메인 불러오기
	@RequestMapping("")
	public String main(@PathVariable("id") String id, HttpSession session) {
		System.out.println("blogController/main()");
		
		session.removeAttribute("blogInfo"); // 기존 "blogInfo" session 삭제
		session.setAttribute("blogInfo", blogService.getBlog(id)); // 'id'의 블로그 정보 --> session
		
		return "/blog/blog-main";
	}
	
	
	// 블로그 관리(기본페이지)
	@RequestMapping("/admin/basic")
	public String adminBasic() {
		System.out.println("blogController/adminBasic()");
		
		return "/blog/admin/blog-admin-basic";
	}
	
	// 블로그 기본설정변경
	@RequestMapping("/admin/basic/changeSet")
	public String changeSet(@ModelAttribute BlogVo vo) {
		System.out.println("blogController/changeSet()");
		System.out.println(vo);
		
		return "redirect:/{id}/admin/basic";
	}

}
