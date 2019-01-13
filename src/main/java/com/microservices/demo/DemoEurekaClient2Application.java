package com.microservices.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class DemoEurekaClient2Application {
	@Autowired
	private EurekaClient client;
	
	@RequestMapping("/serviceinfo")
	public String serviceInfo()
	{
		//InstanceInfo instancenfo = client.getNextServerFromEureka("client1", false);
		//Change this to Client2 for RestTemplate
		InstanceInfo instancenfo = client.getNextServerFromEureka("client2", false);
		return instancenfo.getHomePageUrl();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoEurekaClient2Application.class, args);
	}

}

