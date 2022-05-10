package com.counter.listvalue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import static com.counter.listvalue.utils.CounterUtils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.counter.listvalue.manager.CounterRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
class ListvalueApplicationTests {

//	private MockMvc mvc;
//	
//	@Autowired
//	private TestRestTemplate restTemplate;
//	
//	@Test
//	void contextLoads() {
//	}
//
////	@Test
//	public void hello() {
//		String body = this.restTemplate.getForObject(COUNTER_URL + TEST_COUNTER, String.class);
//		System.out.println(body);
////		assertThat(body).isEqualTo("Hello World");
//	}
//	
//	private String mapToJson(Object obj) throws JsonProcessingException {
//		ObjectMapper objectMapper = new ObjectMapper();
//	    return objectMapper.writeValueAsString(obj);
//	}
//	
////	@Test
//	public void createCounter() throws Exception {
//		String URI = COUNTER_URL + CREATE_COUNTER_URL;
//		CounterRequest counter = new CounterRequest();
//		counter.setCounterName("UnitTest");
//		counter.setIncrementValue(1);
//		String inputJson = mapToJson(counter);
//		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(URI)
//			      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
//		int status = mvcResult.getResponse().getStatus();
//		assertEquals(201, status);
//		String content = mvcResult.getResponse().getContentAsString();
//		assertEquals(content, "Counter is created successfully");
//	}
}
