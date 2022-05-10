package com.counter.listvalue.manager;

public class CounterRequest {
	
	
	private String counterName;
	private int incrementValue;
	
	public String getCounterName() {
        return this.counterName;
    }

    public void setCounterName(String counterName) {
        this.counterName = counterName;
    }

    public int getIncrementValue() {
        return this.incrementValue;
    }

    public void setIncrementValue(int incrementValue) {
        this.incrementValue = incrementValue;
    }
}
