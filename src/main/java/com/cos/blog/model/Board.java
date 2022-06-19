package com.cos.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Board {
	@Id//PK
	@GeneratedValue(strategy = GenerationType.IDENTITY)//디비 넘버링 전략에 따름 
	private int id;
	@Column(nullable=false, length=30)
	private String title;
	@Lob//대용량데이터
	private String content;//섬머노트 라이브러리 <html>태그가 섞여서 디자인이 됨.
	
	private int count;//조회수 !!
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="userId")
	private User user;// DB는 오브젝트를 저장할 수 없다(db엔 integer로 저장). FK, 자바는 오브젝트를 저장할 수 있다. 
	@OneToMany(mappedBy="board", fetch=FetchType.EAGER)
	private List<Reply> replys;
	private Timestamp createDate;
}
