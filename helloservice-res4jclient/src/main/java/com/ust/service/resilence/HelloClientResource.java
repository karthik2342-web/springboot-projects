package com.ust.service.resilence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/api/client")
public class HelloClientResource {
	@Autowired
	RestTemplate template;
	public final static String CLIENT_SERVICE="clientService";
	
	@GetMapping
	@CircuitBreaker(name=CLIENT_SERVICE,fallbackMethod="callonFail")
	public String callServer() {
		String url="http://localhost:8074/rest/service/port";
		String output=template.getForObject(url, String.class);
		return output;
	}
	public String callonFail(Exception e) {
		return "message from callonFail";
	}
}
