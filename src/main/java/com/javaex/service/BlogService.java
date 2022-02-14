package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.BlogDao;
import com.javaex.dao.CategoryDao;
import com.javaex.dao.PostDao;
import com.javaex.vo.BlogVo;

@Service
public class BlogService {
	
	@Autowired
	private BlogDao bd;
	@Autowired
	private CategoryDao cd;
	@Autowired
	private PostDao pd;
	
	
	// 블로그 정보 가져오기
	public Map<String, Object> getBlog(String id) {
		
		// 블로그 메인 포스트 리스트 초기값
		Map<String, Object> pMap= new HashMap<String, Object>();
		pMap.put("id", id);
		pMap.put("cateNo", cd.getTopCateNo(id)); // 최상단 카테고리넘버
		
		
		Map<String, Object> bMap= new HashMap<String, Object>();
		bMap.put("BlogVo", bd.blogInfo(id));
		bMap.put("cateList", cd.getList(id));
		bMap.put("postList", pd.getList(pMap));
		return bMap;
	}
	
	
	// 블로그 기본설정변경
	public BlogVo changeSet(MultipartFile file, BlogVo vo) {
		String saveDir= "C:\\javaStudy\\upload";
		
		String orgName= file.getOriginalFilename(); // 원본파일명
		String exName= orgName.substring(orgName.lastIndexOf(".")); // 확장자
		String saveName= System.currentTimeMillis()+UUID.randomUUID().toString()+exName; // 저장파일명
		String filePath= saveDir+"\\"+saveName; // 저장파일경로
		
		// 업로드
		try {
			byte[] fileData= file.getBytes();
			OutputStream out= new FileOutputStream(filePath);
			BufferedOutputStream bout= new BufferedOutputStream(out);
			
			bout.write(fileData);
			bout.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	
		// db에 저장
		vo.setLogoFile(saveName);
		bd.changeSet(vo);
		
		// 업데이트된 blogInfo 불러오기
		return bd.blogInfo(vo.getBlogId());
	}
}
