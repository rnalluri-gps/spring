package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.ClientResponse;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {
	
	@Autowired
	private GreetingWebClient greetingWebClient;
	
	@GetMapping(value = "")
    public Mono<String> all() {
        return this.greetingWebClient.getResult();
    }

}
