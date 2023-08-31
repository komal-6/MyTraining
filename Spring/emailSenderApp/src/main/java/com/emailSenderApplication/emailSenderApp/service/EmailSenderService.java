package com.emailSenderApplication.emailSenderApp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.emailSenderApplication.emailSenderApp.Details.EmailDetails;

import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmailSenderService {
	@Autowired
	private JavaMailSender mailSender;

	//@Value("${spring.mail.username}")
	private String sender = "komalpanchal113@gmail.com";
	
	Logger log = LoggerFactory.getLogger(EmailSenderService.class);
	
	public void sendEmail(EmailDetails emailDetails) {
		
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		try
		{
			/*
			 * SimpleMailMessage mailMessage = new SimpleMailMessage();
			 * mailMessage.setFrom(sender); mailMessage.setTo(emailDetails.getToEmail());
			 * mailMessage.setSubject(emailDetails.getSubject());
			 * mailMessage.setText(emailDetails.getBody());
			 */
			
			mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
			mimeMessageHelper.setFrom(sender);
			mimeMessageHelper.setTo(emailDetails.getToEmail());
			mimeMessageHelper.setSubject(emailDetails.getSubject());
			mimeMessageHelper.setText(emailDetails.getBody());
			
			FileSystemResource file = new FileSystemResource(emailDetails.getAttachment());
			mimeMessageHelper.addAttachment(file.getFilename(), file);
			//For Sending the mail
			mailSender.send(mimeMessage);
			log.info("Mail sent successfully");
		}
		catch(Exception e) {
			e.printStackTrace();
			log.error("Mail not sent successfully");
		}
	}
}
