package com.cos.blog.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@RestController
public class DummyControllerTest {
	// http://localhost:8000/blog/dummy/join (요청)
		// http의 body에 username, password, email 데이터를 가지고 (요청)
	@Autowired//DI(의존성 주입)빈으로 등록 되어있어서 가능
	private UserRepository userRepository; 
		//전체를 보여줌
		@GetMapping("/dummy/users")
		public List<User> list(){
			return userRepository.findAll();
		}
		
		//다시한번 강의 볼것
		
		/*
		 * @GetMapping("/dummy/user") public List<User>
		 * pageList(@PageableDefault(size=2,sort="id",
		 * direction=Sort.Direction.DESC)Pageable pageable){ Page<User> pagingUser =
		 * userRepository.findAll(pageable); if(pagingUser.isLast()) {
		 * 
		 * } List<User> users = pagingUser.getContent(); return users;
		 * 
		 * }
		 */

		@PostMapping("/dummy/join")
		public String join(User user) { // key=value (약속된 규칙)
			System.out.println("id : "+user.getId());
			System.out.println("username : "+user.getUsername());
			System.out.println("password : "+user.getPassword());
			System.out.println("email : "+user.getEmail());
			System.out.println("role : "+user.getRole());
			System.out.println("createDate : "+user.getCreateDate());
			
			user.setRole(RoleType.USER);
			userRepository.save(user);
			return "회원가입이 완료되었습니다.";
		}
		@GetMapping("/dummy/user/{id}")
		public User detail(@PathVariable int id) {
			/*
			 * User user = userRepository.findById(id).orElseThrow(new
			 * Supplier<IllegalArgumentException>() {
			 * 
			 * @Override public IllegalArgumentException get() { // TODO Auto-generated
			 * method stub return new IllegalArgumentException("해당 사용자가 없습니다"); } });
			 */
			

			User user = userRepository.findById(id).orElseThrow(()-> {
				return new IllegalArgumentException("해당사용자는 없습니다");
			});
			
			//요청은 웹브라우저
			//응답 객체 = 자바 오브젝트
			//스프링 부트 = MessageConverter라는 애가 응답시 자동 작동
			//MessageConverter가 자바 오브젝트 리턴시 자동으로 Jackson 라이브러리 호출 
			//자바객체를 json으로 자동으로 바꿔줌
			return user;
		}
}
