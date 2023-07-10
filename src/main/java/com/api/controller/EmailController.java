package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.entitie.EmailRequest;
import com.api.service.EmailSenderService;

@RestController
public class EmailController {

	 private EmailSenderService emailService;

	    @Autowired
	    public EmailController(EmailSenderService emailService) {
	        this.emailService = emailService;
	    }
	    
	    
	    @PostMapping("/send-email")
	    public void sendEmail(@RequestBody EmailRequest emailRequest) {
	        String to = emailRequest.getTo();
	        String subject = emailRequest.getSubject();
	        String text = emailRequest.getText();
	        emailService.sendSimpleEmail(to, subject, text);
	    }
	
	





}
