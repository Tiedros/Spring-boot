package com.tiedros.springboot.demo.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	// inject values from properties for name and team
	@Value("${name}")
	private String name;
	@Value("${team}")
	private String team;

	// expose "/" that returns " Hello world"
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello world! The time on server is: " + LocalDateTime.now();
	}
	
	// add a new  end point for "/workout"
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run a hard 5k!";
	}
	
	// add a new end point for "fortune"
	@GetMapping("/fortune")
	public String getDailyFortune() {
		return "Today is your lucky day "+ name +" and your team is "+ team;
	}
}
