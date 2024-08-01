package com.eduonix.eurekaclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient 
@SpringBootApplication
public class EurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}

}

@RestController
class BasicController {
	
	@Autowired 
	private DiscoveryClient client;	
	
	@GetMapping("/microservices/{appname}")
	public String microserviceByName(@PathVariable String appname) {
		return client.getInstances(appname).get(0).getUri().toString();
	}
	

	/*public String microserviceByName() {
		return client.getInstances("index.html").toString();
	}*/
	
}