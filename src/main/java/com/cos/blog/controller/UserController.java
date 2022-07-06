package com.cos.blog.controller;



import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.cos.blog.config.auth.PrincipalDetail;
import com.cos.blog.model.OAuthToken;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
	
	@GetMapping("/auth/kakao/callback")
	public @ResponseBody String kakaoCallback(String code) {
		//post방식으로 key=value형식으로 데이터 요청
		RestTemplate rt = new RestTemplate();
		//HttpHeader오브젝트 생성
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");
		
		//Httpbody오브젝트 생성
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "authorization_code");
		params.add("redirect_uri", "http://localhost:8080/auth/kakao/callback");
		params.add("client_id", "b5112a4ec5481bcdcf24c30716b20f74");
		params.add("code", code);
		// Http 헤더와 바디를 하나의 오브젝트에 담기
		HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(params,headers);
		//Http post요청 후 response 받기!!
		ResponseEntity response = rt.exchange("https://kauth.kakao.com/oauth/token", HttpMethod.POST, kakaoTokenRequest, String.class);
		
		//Gson, Json Simple, ObjectMapper
		ObjectMapper objectMapper = new ObjectMapper();
		OAuthToken oauthToken = null;
		try {
			oauthToken = objectMapper.readValue((String)response.getBody(), OAuthToken.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RestTemplate rt2 = new RestTemplate();
		//HttpHeader오브젝트 생성
		HttpHeaders headers2 = new HttpHeaders();
		headers2.add("Authorization","Bearer "+oauthToken.getAccess_token());
		headers2.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");
		
		
		// Http 헤더와 바디를 하나의 오브젝트에 담기
		HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest2 = new HttpEntity<>(headers2);
		//Http post요청 후 response 받기!!
		ResponseEntity response2 = rt2.exchange("https://kapi.kakao.com/v2/user/me"
				, HttpMethod.POST, kakaoProfileRequest2, String.class);
		
		return response2.getBody().toString();
	}
}
