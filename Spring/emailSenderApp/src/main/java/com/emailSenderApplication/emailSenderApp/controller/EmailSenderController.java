package com.emailSenderApplication.emailSenderApp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.emailSenderApplication.emailSenderApp.Details.EmailDetails;
import com.emailSenderApplication.emailSenderApp.service.EmailSenderService;
import lombok.extern.slf4j.Slf4j;


@RestController
//@RequestMapping("mail-api")
@Slf4j
public class EmailSenderController {
	@Autowired
	EmailSenderService emailSenderService;
	
	Logger log = LoggerFactory.getLogger(EmailSenderController.class);
	
	@PostMapping("/sendEmail")
	public String sendSimpleEmail(@RequestBody EmailDetails emailDetails) {
		emailSenderService.sendEmail(emailDetails);
		log.info("Email Sent Successfully");
		return "Mail sent successfully";
	}
}
