package com.techelevator.model;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailHelperClass {
	public static void sendMail(String name, String toEmail, String subject, String message)
			throws MessagingException, UnsupportedEncodingException {

		String username = "team404potholecapstone@gmail.com";
		String password = "#404Pothole";
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		};
		// set any other needed mail.smtp.* properties here
		Session session = Session.getInstance(props, auth);
		MimeMessage msg = new MimeMessage(session);
		// set the message content here
		msg.setFrom(new InternetAddress(username, name));
		msg.setReplyTo(InternetAddress.parse(username, false));
		msg.setSubject(subject);
		msg.setText(message);
		msg.setSentDate(new Date());
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));

		Transport.send(msg);

	}
}
