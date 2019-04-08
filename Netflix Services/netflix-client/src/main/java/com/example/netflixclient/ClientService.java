package com.example.netflixclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ClientService {

	@Autowired
	private EurekaClient eurekaClient;
	//Hystrix fallback handler for netflix-service-1 
	@HystrixCommand(fallbackMethod = "failed")
	public String test1() {
		InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("netflix-service-1",false);
		String serviceBaseUrl = instanceInfo.getHomePageUrl();
		String result = new RestTemplate().getForObject(serviceBaseUrl + "demo1",String.class);
		return result;
		
	}
	
	public String failed() {
		return "<h2>failed from failedd method in netflix client for test1</h2>";
	}
	
	//Hystrix fallback handler for netflix-service-2
	@HystrixCommand(fallbackMethod = "failedd")
	public String test2() {
		InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("netflix-service-2",false);
		String serviceBaseUrl = instanceInfo.getHomePageUrl();
		String result = new RestTemplate().getForObject(serviceBaseUrl + "demo2",String.class);
		return result;
		
	}
	
	public String failedd() {
		return "<h2>failed from failedd method in netflix client for test2</h2>";
	}
	
	
	
}
