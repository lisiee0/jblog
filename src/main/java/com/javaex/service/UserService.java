package com.javaex.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao ud;
	
	
	// 회원가입
	public void join(UserVo vo) {
		
		// ORA-00001: unique constraint (WEBDB.SYS_C007421) violated
		// userNo 값이 중복되어 발생
		// insert 할때 필요한 값만 map에 넣어 dao로 보냄
		
		Map<String, String> map= new HashMap<String, String>();
		map.put("id", vo.getId());
		map.put("userName", vo.getUserName());
		map.put("password", vo.getPassword());
		
		System.out.println("service"+vo);
		
		
		ud.join(map);
	}
}
