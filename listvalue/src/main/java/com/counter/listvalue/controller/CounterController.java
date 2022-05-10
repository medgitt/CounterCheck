package com.counter.listvalue.controller;

import java.util.Date;
import java.util.List;
import static com.counter.listvalue.utils.CounterUtils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.counter.listvalue.entity.Counter;
import com.counter.listvalue.handler.CounterNotFoundException;
import com.counter.listvalue.manager.CounterRequest;
import com.counter.listvalue.manager.CounterResponse;
import com.counter.listvalue.manager.ResponseManager;
import com.counter.listvalue.repository.ICounterService;

@RestController
@RequestMapping(COUNTER_URL)
public class CounterController {
	
	@Autowired
	private ICounterService counterService;
	
	private HttpHeaders getResponseHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.add(SERVER, LOCAL);
		headers.add(DATE, new Date().toString());
		return headers;
	}
	
	@PostMapping(CREATE_COUNTER_URL)
	public ResponseEntity<?> createCounter(@RequestBody CounterRequest counter) {
		int resultCode = counterService.save(counter);
		if(resultCode == -1)
			throw new CounterNotFoundException(HttpStatus.UNPROCESSABLE_ENTITY, COUNTER_EXIST_MESSAGE, counter.getCounterName());
		ResponseManager responseBody = new ResponseManager(CREATED, SUCCESS, 
				counter.getCounterName() + CREATE_COUNTER_MESSAGE);
		return ResponseEntity.created(null).headers(getResponseHeaders()).body(responseBody);
	}
	
	@PutMapping(UPDATE_COUNTER_URL)
	public ResponseEntity<?> updateCounter(@RequestBody CounterRequest counter) {
		int resultCode = counterService.update(counter);
		if(resultCode == -1)
			throw new CounterNotFoundException(HttpStatus.NOT_FOUND, counter.getCounterName());
		ResponseManager responseBody = new ResponseManager(OK, SUCCESS, 
				counter.getCounterName() + UPDATE_COUNTER_MESSAGE);
		return ResponseEntity.ok().headers(getResponseHeaders()).body(responseBody);
	}
	
	@PutMapping(UPDATE_COUNTER_BY_NAME_URL)
	public ResponseEntity<?> updateCounterByName(@PathVariable String counterName) {
		int resultCode = counterService.update(counterName);
		if(resultCode == -1)
			throw new CounterNotFoundException(HttpStatus.NOT_FOUND, counterName);
		ResponseManager responseBody = new ResponseManager(OK, SUCCESS, 
				counterName + UPDATE_COUNTER_MESSAGE);
		return ResponseEntity.ok().headers(getResponseHeaders()).body(responseBody);
	}

	@DeleteMapping(DELETE_COUNTER_BY_NAME_URL)
	public ResponseEntity<?> deleteCounterByName(@PathVariable String counterName) {
		int resultCode = counterService.delete(counterName);
		if(resultCode == -1)
			throw new CounterNotFoundException(HttpStatus.NOT_FOUND, counterName);
		ResponseManager responseBody = new ResponseManager(OK, SUCCESS, 
				counterName + DELETE_COUNTER_MESSAGE);
		return ResponseEntity.ok().headers(getResponseHeaders()).body(responseBody);
	}
	
	@GetMapping(GET_VALUE_BY_COUNTER_URL)
	public ResponseEntity<?> getValueByCounter(@PathVariable String counterName){
		List<Counter> lstCounter = counterService.findByCounterName(counterName);
		if(lstCounter.isEmpty())
			throw new CounterNotFoundException(HttpStatus.NOT_FOUND, counterName);
		CounterResponse<?> responseBody = new CounterResponse<>(OK, SUCCESS, 
				FETCH_COUNTER_MESSAGE + counterName, lstCounter);
		return ResponseEntity.ok().headers(getResponseHeaders()).body(responseBody);
	}
	
	@GetMapping(GET_ALL_COUNTERS_URL)
	public ResponseEntity<?> getCounter(){
		List<Counter> lstCounter = counterService.findAll();
		CounterResponse<?> responseBody = new CounterResponse<>(OK, SUCCESS, 
				FETCH_COUNTER_MESSAGE.split("of")[0].trim(), lstCounter);
		return ResponseEntity.ok().headers(getResponseHeaders()).body(responseBody);
	}
	
	@GetMapping(COUNTERS_TEST_URL)
	public ResponseEntity<?> getHelloWorld() {
		ResponseManager responseBody = new ResponseManager(OK, SUCCESS, HELLOWORLD);
		return ResponseEntity.ok().headers(getResponseHeaders()).body(responseBody);
	}
}
