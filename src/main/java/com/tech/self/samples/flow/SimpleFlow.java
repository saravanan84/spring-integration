package com.tech.self.samples.flow;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;


@EnableIntegration
@IntegrationComponentScan
public class SimpleFlow {

	
	@MessagingGateway
	public interface MainFlow{
		
		@Gateway(requestChannel="requestChannel")
		String hello(String name);
	}
	
	@Bean
	public IntegrationFlow firstFlow() {
		return IntegrationFlows.from("requestChannel")
				.transform("Hello "::concat)
				.get();
	}
	
}
