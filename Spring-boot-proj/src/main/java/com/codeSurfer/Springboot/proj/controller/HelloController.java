package com.codeSurfer.Springboot.proj.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	
	@GetMapping("/")
	public String helloworld() {
		return "hello restful aaa buddies hello";
	}
	
}
