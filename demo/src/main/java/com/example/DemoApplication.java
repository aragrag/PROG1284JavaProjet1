package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// import com.example.service.MqttPubSubService;

@SpringBootApplication
@EntityScan("com.example.model")
@EnableJpaRepositories("com.example.repository")
public class DemoApplication {
		// private MqttPubSubService service;

		public static void main(String[] args) {
			SpringApplication.run(DemoApplication.class, args);
		}
}
