package com.example.netflixservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping("/demo2")
	public String demo() {
		return "<h2>Hi Welcome to netflix-service-2</h2>";
	}
}
