package com.tranquyet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tranquyet.binding.MessageOutput;
import com.tranquyet.model.Student;

@RestController
@RequestMapping("/")
@EnableBinding(MessageOutput.class)
public class ProducerController {
	
	@Autowired
	private MessageOutput out;
	
	@GetMapping
	public String sendMessage() {
		Student student = new Student();
		student.setId("100");
		student.setName("Tran Quyet");
		System.out.println("----------------------------------> SEND: "+student);
		out.sendMessageAmqp().send(MessageBuilder.withPayload(student).build());
		return "Hello World";
	}
	
	
	@GetMapping("test")
	public String sendMessageStudent() {
		Student student = new Student();
		student.setId("100");
		student.setName("Tran Quyet Student");
		System.out.println("----------------------------------> SEND: "+student);
		out.sendMessageAmqp().send(MessageBuilder.withPayload(student).build());
		return "Hello World";
	}
	
}
