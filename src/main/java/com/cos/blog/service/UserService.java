package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public int 회원가입(User user) {
		try {
			userRepository.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("UserService 회원 가입:"+e.getMessage());
			return 1;
		}
		return -1;
		
		
	}
}
