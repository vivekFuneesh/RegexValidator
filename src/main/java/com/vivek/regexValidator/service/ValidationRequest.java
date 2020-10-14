package com.vivek.regexValidator.service;

import javax.validation.constraints.NotBlank;

public class ValidationRequest {

	@NotBlank(message = "regex expression must not be blank or null")
	private String regex;
	
	@NotBlank(message = "string to check must not be blank or null")
	private String requestBody;

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	public String getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}
	
	
}
