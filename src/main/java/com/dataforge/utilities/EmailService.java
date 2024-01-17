package com.dataforge.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailService {

	@Autowired
	private JavaMailSender javamailsender;

	public boolean sendMail(String subject, String body, String to) {

		boolean isSent = false;
		try {
			MimeMessage mimemessage = javamailsender.createMimeMessage();
			MimeMessageHelper helpler = new MimeMessageHelper(mimemessage);
			helpler.setTo(to);
			helpler.setSubject(subject);
			helpler.setText(body, true);
			javamailsender.send(mimemessage);
			isSent = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return isSent;
	}
}
