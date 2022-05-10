package com.counter.listvalue.repository;

import java.util.List;

import com.counter.listvalue.entity.Counter;
import com.counter.listvalue.manager.CounterRequest;

public interface ICounterService {

	List<Counter> findAll();
	List<Counter> findByCounterName(String name);
	int save(CounterRequest counter);
	int update(CounterRequest counter);
	int update(String name);
	int delete(String name);
}
