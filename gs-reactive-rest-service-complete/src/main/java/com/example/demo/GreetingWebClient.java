package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorResourceFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Component("greetingWebClient")
public class GreetingWebClient {
	private static final String OMDB_MIME_TYPE = "application/json";
	private static final String USER_AGENT = "Spring 5 WebClient";
	private Mono<ClientResponse> result ;
	private WebClient webclient;
	

    @Bean
    public WebClient webClient() {
    	this.webclient =  WebClient.builder()
        .build();
    	return this.webclient;
    }

	public Mono<String> getResult() {
		return this.webclient.get()
				.uri("http://localhost:9080/gs-reactive-rest-service/posts")
				.exchange().flatMap(res -> res.bodyToMono(String.class));
//		return ">> result = " + result.flatMap(res -> res.bodyToMono(String.class)).block();
	}
}
