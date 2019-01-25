package com.tech.self.samples.flow;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.Message;

import com.tech.self.samples.pojo.User;


@EnableIntegration
@IntegrationComponentScan
public class EnrichFlow {

	
	@MessagingGateway
	public interface MainFlow{
		
		@Gateway(requestChannel="requestChannel")
		Message<User> enrich(User user);
	}

	
	/**
	 * header enricher - same way as payload (many implementation to add header)
	 * payload enricher.
	 * @return
	 */
	@Bean
	public IntegrationFlow firstFlow() {
		return IntegrationFlows.from("requestChannel")
				.enrichHeaders(h->h.header("key1", "value1")
							.header("key2", "value2"))
				.enrich(p->p.property("gender", "M"))
				.enrich(p->p.propertyExpression("fullName", "payload.firstName+' '+payload.lastName"))
				.enrich(p->p.propertyFunction("salary", f->addSalary()))
				.get();
	}
	
	
	private double addSalary() {
		return 100.00;
	}
}
