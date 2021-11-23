package com.example.emaildemo;

import com.example.emaildemo.Service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class EmailDemoApplication {

	@Autowired
	public SendEmailService service;

	public static void main(String[] args) {
		SpringApplication.run(EmailDemoApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws Exception {
		service.sendSimpleEmail();
	}
}
