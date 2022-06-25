package com.cos.blog.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice//모든 익셉션 받아줌
@RestController
public class GlobalExeptionHandler {
	@ExceptionHandler(value = Exception.class)//모든 익셉션 받음
	public String handlerArgumentExeption(Exception e) {
		return "<h1>"+e.getMessage()+"</h1>" ;
	}
}
