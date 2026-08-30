package com.expensewise.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl {

	@Autowired
	private JavaMailSender jws;
	
	
	
	public void sendMail(String sender)
	{
		SimpleMailMessage ms=new SimpleMailMessage();
		ms.setTo(sender);
		ms.setSubject("Registration succssfull message ");
		ms.setText("we are glade to inform that you have created account succssfully");
		
		jws.send(ms);
	}
}

