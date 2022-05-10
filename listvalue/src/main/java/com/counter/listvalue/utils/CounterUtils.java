package com.counter.listvalue.utils;

public final class CounterUtils {

	public static final String SAMPLE_COUNTER = "Sample";
	public static final int DEFAULT_INCREMENT_VALUE = 1;
	
	public static final String TEST_COUNTER = "Test";
	
	public static final String COUNTER_TABLE = "counter";
	
	public static final String CREATED_AT = "createdAt";
	public static final String UPDATED_AT = "updatedAt";
	public static final String COUNTER_NAME = "counterName";
	public static final String INCREMENT_VALUE = "incrementValue";
	
	public static final String BASE_URL = "/api";
	public static final String COUNTER_URL = BASE_URL + "/counter";
	public static final String CREATE_COUNTER_URL = "/create_counter";
	public static final String GET_VALUE_BY_COUNTER_URL = "/get_value_by_counter/{counterName}";
	public static final String GET_ALL_COUNTERS_URL = "/get_all_counters";
	public static final String UPDATE_COUNTER_URL = "/update_counter";
	public static final String UPDATE_COUNTER_BY_NAME_URL = "/update_counter/{counterName}";
	public static final String DELETE_COUNTER_BY_NAME_URL = "/delete_counter/{counterName}";
	public static final String COUNTERS_TEST_URL = "/test";

	public static final String STATUS = "status";
	public static final String MESSAGE = "message";
	public static final String DESCRIPTION = "description";
	public static final String SUCCESS = "success";
	public static final String ERROR = "error";
	public static final int OK = 200;
	public static final int CREATED = 201;
	public static final String SERVER = "Server";
	public static final String LOCAL = "Windows/Local System";
	public static final String DATE = "Date";
	
	public static final String HELLOWORLD = "Hello World";
	public static final String COUNTER_EXCEPTION_MESSAGE = "Could not find a counter ";
	public static final String FETCH_COUNTER_MESSAGE = "Successfully fetched all values of ";
	public static final String COUNTER_EXIST_MESSAGE = " is already available.";
	public static final String CREATE_COUNTER_MESSAGE = " counter is successfully created.";
	public static final String UPDATE_COUNTER_MESSAGE = " counter is successfully updated.";
	public static final String DELETE_COUNTER_MESSAGE = " counter is successfully deleted.";
}
