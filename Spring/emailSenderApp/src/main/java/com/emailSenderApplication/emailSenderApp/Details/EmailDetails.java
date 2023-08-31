package com.emailSenderApplication.emailSenderApp.Details;


public class EmailDetails {

	private String toEmail;
	private String subject;
	private String body;
	private String attachment;
	
	public EmailDetails() {
		super();
	}
	public EmailDetails(String toEmail, String subject, String body) {
		super();
		this.toEmail = toEmail;
		this.subject = subject;
		this.body = body;
	}
	public String getToEmail() {
		return toEmail;
	}
	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
}
