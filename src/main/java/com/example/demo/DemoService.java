package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@Service
public class DemoService {

	private static final Logger logger = LoggerFactory.getLogger(WebController.class);

	private Counter counter;
	
	public DemoService(MeterRegistry registry) {
		counter = registry.counter("de.testsysteme.micrometer.demo");
	}
	
	@Cacheable(value = "attribute", key = "#attrkey")
	public String attr(String attrkey) {
		logger.info("Used cache for " + attrkey);
		return "World";
	}
	
	public void count() {
		counter.increment();
		logger.info("Count to " + counter.count());
	}
}
