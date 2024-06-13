package com.qf.androidautomation.utils;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class EmailReports {

	public static void sendMail() {
		try {
			Config config = new Config();
			EmailAttachment attachment = new EmailAttachment();
			attachment.setPath(config.getProperty("mail.report"));
			attachment.setDisposition(EmailAttachment.ATTACHMENT);
			attachment.setDescription("Test");

			MultiPartEmail email = new MultiPartEmail();

			email.setHostName("smtp.googlemail.com");
			email.setSSLOnConnect(true);

			email.setSmtpPort(587);
			email.setAuthenticator(
					new DefaultAuthenticator(config.getProperty("mail.sender"), config.getProperty("mail.password")));

			email.addTo(config.getProperty("mail.reciver"));
			String[] ccRecipients = config.getProperty("mail.ccRecipient").split(",");
			email.setFrom(config.getProperty("mail.sender"));
			email.setSubject("Test Automation Report");
			email.setMsg("Quara Finanace App Test Report");
			email.attach(attachment);
			email.addCc(ccRecipients);
			email.send();
			System.out.println("Email sent successfully!");
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}
}
