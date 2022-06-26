package com.cos.blog.repository;

import java.util.Optional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cos.blog.model.User;
//객체, 프라이머리키의 타입
//dao
//JpaRepository을 상속 받음 으로서 여러 crud함수를 쓸수있다, 자도으로 빈 등록
//@Repository 생략가능
public interface UserRepository extends JpaRepository<User, Integer> {
	//select * from user where username=1?
	Optional<User> findByUsername(String username);
}
//JpaRepository을 상속 받음 으로서 여러 crud함수를 쓸수있다

	//밑의 두가지 전랴 모두 가능하다
	//@Query(value="Select * FROM user WHERE username = ?1 AND password = ?2", nativeQuery = true)
	//User login(String username, String password);

	//JPA 의 네이밍 전략
	//User findByUsernameAndPassword(String username, String password);
