package com.in28minutes.springboot.firstrestapi.helloworld;

import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {
	
	@RequestMapping("/hello-world")
	public String helloWorld() {
		return "helloworld";
	}
	
	@RequestMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("helloworldbean");
	}
	
	@RequestMapping("/hello-world-path-param/{name}")
	public HelloWorldBean helloWorldPathParam(@PathVariable String name) {
		return new HelloWorldBean("hello world, "+name);
	}
}
		