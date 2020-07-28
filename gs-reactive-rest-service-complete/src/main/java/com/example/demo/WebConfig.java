/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import lombok.Getter;
import lombok.Setter;


@Configuration
@EnableWebFlux
@Getter
@Setter
@ComponentScan(basePackages = "com.example.demo")
class WebConfig implements WebFluxConfigurer {
	
//	@Autowired
//	private GreetingHandler greetingHandler;
//	
	@Bean
	public RouterFunction<ServerResponse> route(GreetingHandler greetingHandler) {

		return RouterFunctions
			.route(RequestPredicates.GET("/hello")
									.and(
											RequestPredicates.accept(MediaType.TEXT_PLAIN)), greetingHandler::hello);
	}
	
	
}