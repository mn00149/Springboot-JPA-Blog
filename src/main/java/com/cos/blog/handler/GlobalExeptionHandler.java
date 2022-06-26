package com.cos.blog.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.dto.ResponseDto;

@ControllerAdvice//모든 익셉션 받아줌
@RestController
public class GlobalExeptionHandler {
	@ExceptionHandler(value = Exception.class)//모든 익셉션 받음
	public ResponseDto<String> handlerArgumentExeption(Exception e) {
		return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
	}
}
