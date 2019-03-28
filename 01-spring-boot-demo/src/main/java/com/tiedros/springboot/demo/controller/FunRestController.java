package com.tiedros.springboot.demo.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	// expose "/" that returns " Hello world"
	
	@RequestMapping("/")
	public String sayHello() {
		return "Hello world! The time on server is: " + LocalDateTime.now();
	}
}
