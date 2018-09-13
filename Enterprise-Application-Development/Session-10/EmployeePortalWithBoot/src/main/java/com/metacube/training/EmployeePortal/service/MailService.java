package com.metacube.training.EmployeePortal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.metacube.training.EmployeePortal.model.Mail;

@Service
public class MailService {
	@Autowired
	private JavaMailSender emailSender;

	public void sendSimpleMessage(final Mail mail) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject(mail.getSubject());
		message.setText(mail.getContent());
		message.setTo(mail.getTo());
		message.setFrom(mail.getFrom());

		emailSender.send(message);
	}
}
