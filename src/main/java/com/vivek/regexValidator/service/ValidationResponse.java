package com.vivek.regexValidator.service;

public class ValidationResponse {

	private String match;
	private boolean error;
	
	public String getMatch() {
		return match;
	}
	public void setMatch(String match) {
		this.match = match;
	}
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	
}
