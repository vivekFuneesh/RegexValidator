package com.vivek.regexValidator.glitches;

import javax.validation.ValidationException;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Glitches {

	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<?> handleConstraints(ValidationException e){
		System.out.println("eee");
		return ResponseEntity.badRequest().body(e);
	}
	
	@ExceptionHandler(BindException.class)
	public ResponseEntity<?> handleConstraints(BindException e){
		System.out.println("bebe");	
		return ResponseEntity.badRequest().body(e.getFieldErrors().stream().map(x->x.getField()+" :: "+x.getDefaultMessage()));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleConstraints(MethodArgumentNotValidException e){
		System.out.println("manvemanve");	
		return ResponseEntity.badRequest().body(e.getBindingResult().getFieldErrors().stream().map(x->x.getField()+" :: "+x.getDefaultMessage()));
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleConstraints(Exception e){
		System.out.println("exception");	
		return ResponseEntity.badRequest().body(e.getLocalizedMessage());
	}
	
}
