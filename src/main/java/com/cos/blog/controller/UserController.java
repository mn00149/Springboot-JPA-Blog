package com.cos.blog.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.cos.blog.config.auth.PrincipalDetail;
//인증이 안된 사용자들은 /auth만 허용
// 주소가 /인 경우 에는 index.jsp허용
@Controller
public class UserController {

	@GetMapping("/auth/joinForm")
	public String joinForm() {
		return "/user/joinForm";
	}
	
	@GetMapping("/auth/loginForm")
	public String loginForm() {
		return "/user/loginForm";
	}
	
	@GetMapping("/user/updateForm")
	public String updateForm(@AuthenticationPrincipal PrincipalDetail principal) {
		return "/user/updateForm";
	}
}
