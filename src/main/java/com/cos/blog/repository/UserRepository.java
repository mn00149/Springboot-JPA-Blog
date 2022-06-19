package com.cos.blog.repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cos.blog.model.User;
//객체, 프라이머리키의 타입
//dao
//JpaRepository을 상속 받음 으로서 여러 crud함수를 쓸수있다, 자도으로 빈 등록
//@Repository 생략가능
public interface UserRepository extends JpaRepository<User, Integer> {


//JpaRepository을 상속 받음 으로서 여러 crud함수를 쓸수있다
}
