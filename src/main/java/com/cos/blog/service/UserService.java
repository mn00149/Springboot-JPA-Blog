package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
//스프링이 컴포넌드 스캔을 통해 bean에 등록
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	@Transactional
	public void 회원가입(User user) {
		String rawPassword = user.getPassword();
		String encPassword = encoder.encode(rawPassword);
		user.setPassword(encPassword);
		user.setRole(RoleType.USER);
		userRepository.save(user);		
		
	}

	@Transactional
	public void 회원수정(User user) {
		
		//수정시에는 영속석 컨택스트에 User오브젝트를 영속화 시키고 영속화된 User오브젝트를 수정
		//select하여 User오브젝트를 가져오는 이유는 영속화 위해 = >영속화된 오브젝트를 변경하면 DB에 UPdate를 날려주기 떄문
		User persistance = userRepository.findById(user.getId()).orElseThrow(()->{
			return new IllegalArgumentException("회원 찾기 실패");
		}) ;
		String rawPassword = user.getPassword();
		String encPassword = encoder.encode(rawPassword);
		persistance.setEmail(user.getEmail());
		persistance.setPassword(encPassword);
		//회원 수정함수 종료시= 서비스 종료시= 트랜젝션 종료= 자동커밋= 영속화된 퍼시스턴스 객체의 변화감지(더티체킹시) 변화된것을 자동 업댓 
	}
	
	/*
	 * @Transactional(readOnly = true)//select할떄 트랜젝션 시작 종료시 트랜잭션 종료(정합성) public
	 * User 로그인(User user) { return
	 * userRepository.findByUsernameAndPassword(user.getUsername(),
	 * user.getPassword()); }
	 */
}
