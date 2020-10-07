package com.lgtecnologies.springboot.app.item;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfiguration {
	
	@Bean("clienteRest")
	public RestTemplate resgistrarRestTemplate() {
		return new RestTemplate();
		
	}

}
