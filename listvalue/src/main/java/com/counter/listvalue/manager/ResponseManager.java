package com.counter.listvalue.manager;

public class ResponseManager {
	private int code;
	private String status;
	private String message;
	
	public ResponseManager(int code, String status, String message) {
		this.code = code;
		this.status = status;
		this.message = message;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return this.code;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
}
