package com.tech.self.samples.flow;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tech.self.samples.flow.EnrichFlow.MainFlow;
import com.tech.self.samples.pojo.User;

@ContextConfiguration(classes= {EnrichFlow.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class EnrichFlowTest {

	
	@Autowired
	MainFlow flow;
	
	
	@Test
	public void testSimpleFlow() {
		User user = new User();
		user.setFirstName("Saravanan");
		user.setLastName("Ramamoorthy");
		Message<User> message = flow.enrich(user);
		System.out.println("***************");
		System.out.println(message.getHeaders());
		User outUser = message.getPayload();
		System.out.println(outUser.getFullName()+" "+outUser.getGender()+ " "+outUser.getSalary());
	}
}
