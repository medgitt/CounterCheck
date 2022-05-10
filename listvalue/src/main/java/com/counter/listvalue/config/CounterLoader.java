package com.counter.listvalue.config;

import java.util.List;
import static com.counter.listvalue.utils.CounterUtils.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.counter.listvalue.entity.Counter;
import com.counter.listvalue.repository.ICounterRepository;

@Configuration
public class CounterLoader {

	@Bean
	CommandLineRunner init(ICounterRepository counterRepository) {
		List<Counter> counters = counterRepository.findAll();
		if(counters.size() == 0)
			return args -> {
				counterRepository.save(new Counter(SAMPLE_COUNTER, DEFAULT_INCREMENT_VALUE));
				counterRepository.save(new Counter(TEST_COUNTER, DEFAULT_INCREMENT_VALUE));
			};
		return null;
	}
}
