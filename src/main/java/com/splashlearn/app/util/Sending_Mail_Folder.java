package com.splashlearn.app.util;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.zeroturnaround.zip.ZipUtil;

import com.splashlearn.app.library.AppiumLibrary;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Sending_Mail_Folder extends AppiumLibrary {

	public Sending_Mail_Folder(AppiumDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static void SendMail(String SendFrom, String SendTo, String TestName, String FolderName, String Subject)
			throws IOException {

		final String username = SendFrom;
		final String password = "Trigger.16@";

		Properties props = new Properties();
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(SendFrom));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(SendTo));
			message.setSubject(Subject + " for " + TestName);
			message.setText(
					"Please find the attached " + Subject + " for the Test Case " + TestName + " with this mail.");

			MimeBodyPart messageBodyPart = new MimeBodyPart();

			Multipart multipart = new MimeMultipart();

			messageBodyPart = new MimeBodyPart();

			String from = System.getProperty("user.dir") + "//" + FolderName;
			String to = System.getProperty("user.dir") + "//" + FolderName + ".zip";

			ZipUtil.pack(new File(from), new File(to));

			DataSource source = new FileDataSource(to);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(FolderName + ".zip");
			multipart.addBodyPart(messageBodyPart);

			message.setContent(multipart);

			System.out.println("Sending");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}
}