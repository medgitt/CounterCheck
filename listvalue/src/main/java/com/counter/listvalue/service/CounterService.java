package com.counter.listvalue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import static com.counter.listvalue.utils.CounterUtils.*;

import com.counter.listvalue.entity.Counter;
import com.counter.listvalue.manager.CounterRequest;
import com.counter.listvalue.repository.ICounterRepository;
import com.counter.listvalue.repository.ICounterService;
@Service
public class CounterService implements ICounterService{

	@Autowired
	private ICounterRepository counterRepository;
	
	@Override
	public List<Counter> findAll() {
		return (List<Counter>) counterRepository.findAll();
	}

	@Override
	public List<Counter> findByCounterName(String name) {
		Counter counter = new Counter();
		counter.setCounterName(name);
		ExampleMatcher matcher = ExampleMatcher.matching().withMatcher(COUNTER_NAME, 
				match -> match.exact()).withIgnorePaths(INCREMENT_VALUE);
		Example<Counter> exCounter = Example.of(counter, matcher);
		return counterRepository.findAll(exCounter);
	}
	
	@Override
	public int save(CounterRequest counter) {
		List<Counter> lstCounter = findByCounterName(counter.getCounterName());
		if(lstCounter.isEmpty()) {
			counterRepository.save(new Counter(counter.getCounterName(), counter.getIncrementValue()));
			return 0;
		}
		return -1;
	}

	private int updateCounter(String name, int value) {
		List<Counter> lstCounter = findByCounterName(name);
		if(!lstCounter.isEmpty()) {
			for(Counter counter : lstCounter) {
				int count = counter.getIncrementValue();
				count = value == 0 ? count + 1 : count + value;
				counter.setIncrementValue(count);
				counterRepository.save(counter);
			}
			return 0;
		}
		return -1;
	}
	
	@Override
	public int update(CounterRequest newCounter) {
		return updateCounter(newCounter.getCounterName(), newCounter.getIncrementValue());
	}

	@Override
	public int update(String name) {
		return updateCounter(name, 0);
	}

	@Override
	public int delete(String name) {
		List<Counter> lstCounter = findByCounterName(name);
		if(!lstCounter.isEmpty()) {
			for(Counter counter : lstCounter) {
				counterRepository.delete(counter);
			}
			return 0;
		}
		return -1;
	}
}
