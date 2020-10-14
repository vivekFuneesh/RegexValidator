package com.vivek.regexValidator.handler;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.regexValidator.service.ServiceMeValidator;
import com.vivek.regexValidator.service.ValidationRequest;
import com.vivek.regexValidator.service.ValidationResponse;

@RestController
public class PatternValidator {

	@Autowired
	ServiceMeValidator smv;
	
	@PostMapping("/regex")
	public ResponseEntity<ValidationResponse> validateRegex( @RequestBody @Valid  ValidationRequest vrq) {
		return smv.checkAndFind(vrq);
	}
	
}
