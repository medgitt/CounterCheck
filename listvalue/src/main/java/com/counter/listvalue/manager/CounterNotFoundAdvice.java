package com.counter.listvalue.manager;

import java.util.HashMap;
import static com.counter.listvalue.utils.CounterUtils.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.counter.listvalue.handler.CounterNotFoundException;

@ControllerAdvice
public class CounterNotFoundAdvice {

	@ResponseBody
	@ExceptionHandler(CounterNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<?> counterNotFoundManager(CounterNotFoundException counterException) {
		HttpStatus code = counterException.getCode();
		HashMap<String, String> errorResponse = new HashMap<>();
	    errorResponse.put(STATUS, ERROR);
	    errorResponse.put(MESSAGE, counterException.getLocalizedMessage());
	    errorResponse.put(DESCRIPTION, code.toString());
		return new ResponseEntity<>(errorResponse, code);
	}
}
