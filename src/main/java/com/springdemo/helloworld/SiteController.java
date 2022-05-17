package com.springdemo.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class SiteController {
	private static final String template = "Hello %s!";

	private final AtomicLong counter = new AtomicLong();

	@RequestMapping
	public String helloWorld() {
		return "Hello World from Spring Boot";
	}

	@RequestMapping("/goodbye")
	public String goodbye() {
		return "Goodbye from Spring Boot";
	}

	// GetMapping for HTTP GET requests
	@GetMapping("/greeting")

	/** Bind's the given <b>name</b> parameter's value into the <b>name</b> variable for this method's header. */
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "Empty") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
