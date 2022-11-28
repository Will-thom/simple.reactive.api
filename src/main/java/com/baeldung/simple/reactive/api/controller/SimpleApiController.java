package com.baeldung.simple.reactive.api.controller;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class SimpleApiController {

	@GetMapping(value = "/flux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<String> returnFlux(){
		
		return Flux.just("name: Foo", "id: 1")
				.delayElements(Duration.ofSeconds(1))
				.log();
	}
}
