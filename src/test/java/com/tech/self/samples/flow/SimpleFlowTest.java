package com.tech.self.samples.flow;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tech.self.samples.flow.SimpleFlow.MainFlow;

@ContextConfiguration(classes= {SimpleFlow.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SimpleFlowTest {

	
	@Autowired
	MainFlow flow;
	
	
	@Test
	public void testSimpleFlow() {
		System.out.println(flow.hello("saravanan"));
	}
}
