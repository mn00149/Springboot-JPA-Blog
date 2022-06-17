package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

@Entity//이 클래스가 자동으로 테이블 설정 해준다
public class User {
	@Id//PK
	@GeneratedValue(strategy = GenerationType.IDENTITY)//디비 넘버링 전략에 따름 
	private int id;
	@Column(nullable=false, length=30)
	private String username;
	@Column(nullable=false, length=100)//암호화된 비번 저장할거라 길게설정
	private String password;
	@Column(nullable=false, length=0)
	private String email;
	@CreationTimestamp//시간 자동입력
	private Timestamp createDate;
	@ColumnDefault("'user'")
	private String role;//Enum 쓰는게 좋다

}