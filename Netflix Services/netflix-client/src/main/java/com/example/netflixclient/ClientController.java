package com.example.netflixclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

	@Autowired
	private ClientService clientService;
	//Mapping for netflix-service-1 using netflix-client
	@GetMapping("/netflix-service-1")
	public String test1(){
		return clientService.test1();
	}
	
	//Mapping for netflix-service-2 using netflix-client
	@GetMapping("/netflix-service-2")
	public String test2(){
		return clientService.test2();
	}
	
	
}
