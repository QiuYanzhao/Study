package com.example.mq;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ExampleConsumer {

	@KafkaListener(topics = {"example", "test"}, groupId = "my-group")
	public void listen(String message) {

		System.out.println("===========================");
		System.out.println("Received message: " + message);
		System.out.println("===========================");
	}

}
