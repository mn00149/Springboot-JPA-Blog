package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity//이 클래스가 자동으로 테이블 설정 해준다

//@DynamicInsert//인서트시 널 필드 제외 ,디폴트값 넣어주기 용이
public class User {
	@Id//PK
	@GeneratedValue(strategy = GenerationType.IDENTITY)//디비 넘버링 전략에 따름 
	private int id;
	@Column(nullable=false, length=30)
	private String username;
	@Column(nullable=false, length=100)//암호화된 비번 저장할거라 길게설정
	private String password;
	@Column(nullable=false, length=50)
	private String email;
	@CreationTimestamp//시간 자동입력
	private Timestamp createDate;
	//DB는 RoleType이 없으므로
	@Enumerated(EnumType.STRING)
	private RoleType role;//Enum 쓰는게 좋다//ADMIN, USER

}
