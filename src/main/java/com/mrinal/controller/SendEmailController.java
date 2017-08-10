package com.mrinal.controller;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sendEmail")
public class SendEmailController {

	@Autowired
	private JavaMailSender  sender;
	
	@CrossOrigin(origins = "http://localhost:8100", maxAge = 7200)
	@RequestMapping("/testEmail")
	@ResponseBody
	String home(){
		try{
			sendEmail();
			return "Email Sent";
		}catch(Exception e){
			e.printStackTrace();
			return "Error in sending email "+e;
		}
		
	}
	
	private void sendEmail() throws Exception{
	  MimeMessage message = sender.createMimeMessage();
	  MimeMessageHelper helper = new MimeMessageHelper(message);
	  
	  helper.setTo("mrinal.blr16@gmail.com");
	  helper.setText("Hello this is just the test mail ,How are you doing ?");
	  helper.setSubject("Test Mail");
	  sender.send(message);
	  
	}
}
