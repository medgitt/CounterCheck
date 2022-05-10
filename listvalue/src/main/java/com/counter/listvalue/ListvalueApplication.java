package com.counter.listvalue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class ListvalueApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListvalueApplication.class, args);
	}
}
