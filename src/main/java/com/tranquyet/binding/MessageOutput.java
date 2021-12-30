package com.tranquyet.binding;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MessageOutput {
	// topic exchange. use this name to configuration at the application.properties
	String SEND_MESSAGE ="sendMessage";
	// direct exchange. use this name to configuration at the application.properties
	String SEND_STUDENT = "sendStudent";
	
	
	@Output(SEND_MESSAGE)
	MessageChannel sendMessageAmqp();
	
	@Output(SEND_STUDENT)
	MessageChannel sendStudentAmqp();

}
