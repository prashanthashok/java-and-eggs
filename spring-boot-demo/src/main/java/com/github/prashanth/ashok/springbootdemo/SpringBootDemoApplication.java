package com.github.prashanth.ashok.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

	@GetMapping("/hello/{name}")
	public String hello(@PathVariable("name") String name){
		return "Hello " + name;
	}

	@GetMapping("/get")
	public @ResponseBody ResponseEntity<String> get(){
		return new ResponseEntity<String>("GET Response", HttpStatus.OK);
	}

}