package com.counter.listvalue.manager;

public class CounterResponse<T> {

	private int code;
	private String status;
	private String message;
	private T data;
	
	public CounterResponse(int code, String status, String message, T data) {
		this.code = code;
		this.status = status;
		this.message = message;
		this.data = data;
	}
	
	public CounterResponse(int code, String status, String message) {
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
	
	public void setData(T data) {
		this.data = data;
	}
	
	public T getData() {
		return this.data;
	}
}
