package com.counter.listvalue.handler;

import static com.counter.listvalue.utils.CounterUtils.*;

import org.springframework.http.HttpStatus;

public class CounterNotFoundException extends RuntimeException {

	private HttpStatus code;
	
	public CounterNotFoundException(HttpStatus code, String counter) {
		super(COUNTER_EXCEPTION_MESSAGE + counter + ".");
		this.code = code;
	}
	
	public CounterNotFoundException(HttpStatus code, String message, String counter) {
		super(counter + message);
		this.code = code;
	}
	
	public void setCode(HttpStatus code) {
		this.code = code;
	}
	
	public HttpStatus getCode() {
		return this.code;
	}
}
