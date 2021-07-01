package com.github.prashanthashok.learning.multimodule.application;

import com.github.prashanthashok.learning.multimodule.service.MyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "com.github.prashanthashok.learning.multimodule")
@RestController
public class DemoApplication {

	private final MyService myService;

	public DemoApplication(MyService myService){
		this.myService = myService;
	}

	@GetMapping("/")
	public String home() {
		return myService.message();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
