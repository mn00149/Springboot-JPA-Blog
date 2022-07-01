package com.cos.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.config.auth.PrincipalDetail;
import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;

@RestController
public class UserApiController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	/*매서드 파라에 넣는 대신 이렇게도 가능하다
	 * @Autowired 
	 * private HttpSession session;
	 */
	@PutMapping("/user")
	public ResponseDto<Integer> update(@RequestBody User user, 
			@AuthenticationPrincipal PrincipalDetail principal){//@RequestBody요게 없으면 key=value, x-www-form-urlencoded형태로만 받을 수 있음
		userService.회원수정(user);//여기서 트랜젝션은 종료되었으므로 DB값은 변경 하지만 세션값은 그대로
		//따라서 세션갑은 직접 바꾸어 줘야 한다
		//세션 등록
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
		
		
	}
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user){
		System.out.println("UserApiController: save 호출");
		
		
		
		userService.회원가입(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);//자바오브젝트를 json으로 리턴
	}
	//전통적인 로그인 방식으로써 시큐리티로 로그인시 이방법은 잘 쓰여지지 않는다
	/*
	 * @PostMapping("/api/user/login") public ResponseDto<Integer>
	 * login(@RequestBody User user, HttpSession session){
	 * System.out.println("UserApiController login() 호출"); User principal =
	 * userService.로그인(user); if(principal != null) {
	 * session.setAttribute("principal", principal); } return new
	 * ResponseDto<Integer>(HttpStatus.OK.value(), 1);//자바오브젝트를 json으로 리턴 }
	 */
}
