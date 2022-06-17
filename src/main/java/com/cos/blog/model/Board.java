package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

public class Board {
	@Id//PK
	@GeneratedValue(strategy = GenerationType.IDENTITY)//디비 넘버링 전략에 따름 
	private int id;
	@Column(nullable=false, length=30)
	private String title;
	@Lob//대용량데이터
	private String content;//
	
	private int count;
	
	private int userId;
	
	private Timestamp createDate;
}
