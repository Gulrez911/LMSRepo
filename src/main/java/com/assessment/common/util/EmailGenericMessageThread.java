package com.assessment.common.util;

import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

import javax.mail.util.ByteArrayDataSource;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.assessment.Exceptions.AssessmentGenericException;
import com.assessment.common.PropertyConfig;
import com.assessment.services.FileStatusService;

public class EmailGenericMessageThread implements Runnable {
	private String emailSentTo;

	private String subject;

	private String message;

	String emailSentCC;

	PropertyConfig config;

	String pdfAttachmentFile;

	String pdfAttachmentFileName;
	String ccArray[];
	static Logger logger = LoggerFactory.getLogger(EmailGenericMessageThread.class);

	boolean setStatus = false;

	FileStatusService fileStatusService;

	static String from1 = "rahul.chaubey@thev2technologies.com";
	static String pwd1 = "3KV&VbAa";

	static String from2 = "gulrez.farooqui@thev2technologies.com";
	static String pwd2 = "3mBXgY*h";

	static String from3 = "anwarul.hasan@thev2technologies.com";
	static String pwd3 = "3QK>nnAa";

	static String from4 = "anil.gaud@thev2technologies.com";
	static String pwd4 = "5C>R>7jL";

	private static String defaultSender = "rahul.chaubey@thev2technologies.com";

	private static AtomicInteger successCount = new AtomicInteger(0);

	private static AtomicInteger failureCount = new AtomicInteger(0);

	private static synchronized void incrementSuccessCount() {
		int suc = successCount.incrementAndGet();
		System.out.println("success count " + suc);
		logger.info("success count " + suc);
	}

	private static synchronized void incrementFailureCount() {
		int fal = failureCount.incrementAndGet();
		System.out.println("failure count " + fal);
		logger.info("failure count " + fal);
	}

	private static synchronized FromSender getFromEmailSender() {
		if (defaultSender.equalsIgnoreCase("rahul.chaubey@thev2technologies.com")) {
			FromSender fromSender = new FromSender();
			fromSender.setEmail(from1);
			fromSender.setPassword(pwd1);
			defaultSender = "gulrez.farooqui@thev2technologies.com";
			logger.info("email sent on behalf of " + fromSender.getEmail());
			return fromSender;
		} else if (defaultSender.equalsIgnoreCase("gulrez.farooqui@thev2technologies.com")) {
			FromSender fromSender = new FromSender();
			fromSender.setEmail(from2);
			fromSender.setPassword(pwd2);
			defaultSender = "anwarul.hasan@thev2technologies.com";
			logger.info("email sent on behalf of " + fromSender.getEmail());
			return fromSender;
		} else if (defaultSender.equalsIgnoreCase("anwarul.hasan@thev2technologies.com")) {
			FromSender fromSender = new FromSender();
			fromSender.setEmail(from3);
			fromSender.setPassword(pwd3);
			defaultSender = "anil.gaud@thev2technologies.com";
			logger.info("email sent on behalf of " + fromSender.getEmail());
			return fromSender;
		} else if (defaultSender.equalsIgnoreCase("anil.gaud@thev2technologies.com")) {
			FromSender fromSender = new FromSender();
			fromSender.setEmail(from4);
			fromSender.setPassword(pwd4);
			defaultSender = "rahul.chaubey@thev2technologies.com";
			logger.info("email sent on behalf of " + fromSender.getEmail());
			return fromSender;
		} else {
			FromSender fromSender = new FromSender();
			fromSender.setEmail(from1);
			fromSender.setPassword(pwd1);
			logger.info("can not come here....email sent on behalf of " + fromSender.getEmail());
			return fromSender;
		}
	}

	public EmailGenericMessageThread(String emailSentTo, String subject, String message,
			PropertyConfig propertyConfig) {
		this.emailSentTo = emailSentTo;
		this.subject = subject;
		this.message = message;
		config = propertyConfig;

	}

	public EmailGenericMessageThread(String emailSentTo, String subject, String message,
			PropertyConfig propertyConfig, FileStatusService fileStatusService) {
		this.emailSentTo = emailSentTo;
		this.subject = subject;
		this.message = message;
		config = propertyConfig;
		this.fileStatusService = fileStatusService;
	}

	public EmailGenericMessageThread(String emailSentTo, String subject, String message, String cc,
			PropertyConfig propertyConfig) {
		this.emailSentTo = emailSentTo;
		this.subject = subject;
		this.message = message;
		this.emailSentCC = cc;
		config = propertyConfig;
	}

	public EmailGenericMessageThread(String emailSentTo, String subject, String message, String cc,
			PropertyConfig propertyConfig, String pdfAttachmentFile, String pdfAttachmentFileName) {
		this.emailSentTo = emailSentTo;
		this.subject = subject;
		this.message = message;
		this.emailSentCC = cc;
		config = propertyConfig;
		this.pdfAttachmentFile = pdfAttachmentFile;
		this.pdfAttachmentFileName = pdfAttachmentFileName;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {

			HtmlEmail email = new HtmlEmail();
			String host = config.getHostName();
			// String from = config.getSendFrom();
			FromSender fromSender = getFromEmailSender();
			String from = fromSender.getEmail();
			String fromName = config.getSendFromName();
			// String pass = config.getSendFromPassword();
			String pass = fromSender.getPassword();
			String smtpPort = config.getSmtpPort();
			email.setHostName(host);
			logger.info("port is " + Integer.parseInt(smtpPort));
			email.setSmtpPort(Integer.parseInt(smtpPort));
			// email.addTo("jatin.sutaria@thev2technologies.com");
//			String bccs[] = { "jatin.sutaria@thev2technologies.com", "sreeram.gopal@iiht.com" };
//			email.addBcc(bccs);// keep 4 arguments.

			email.addTo(emailSentTo);
			if (getEmailSentCC() != null && getEmailSentCC().trim().length() > 0) {
				System.out.println("cc is " + getEmailSentCC());
				email.addCc(emailSentCC);
			}

			if (getCcArray() != null && getCcArray().length > 0) {
				System.out.println("ccsssss is " + getEmailSentCC());
				email.addCc(getCcArray());
			}
			email.setHtmlMsg(message);
			email.setSubject(subject);
			email.setCharset("UTF-8");

			email.setFrom(from, fromName);

			email.setAuthenticator(new DefaultAuthenticator(from, pass));
			email.setTLS(false);// change here
			// email.setSmtpPort(Integer.parseInt(smtpPort));
			email.setSSL(true);
			// email.setDebug(true);
			/**
			 * Send attachment if there
			 */
			if (this.pdfAttachmentFile != null && this.pdfAttachmentFileName != null) {
				byte data[] = FileUtils.readFileToByteArray(new File(this.pdfAttachmentFile));
				email.attach(new ByteArrayDataSource(data, "application/pdf"),
						pdfAttachmentFileName + ".pdf", "Document description",
						EmailAttachment.ATTACHMENT);
			}
			/**
			 * End attachemnt code
			 */

			// send the email
			// email.send();
			email.buildMimeMessage();
			logger.info("fileStatusService " + fileStatusService);
			System.out.println("fileStatusService " + fileStatusService);

			email.sendMimeMessage();
			System.out.println("Email Sent");
			logger.info("mail sent to " + emailSentTo);

			if (isSetStatus() && fileStatusService != null) {
//			  		System.out.println("saving status");
//			  		com.assessment.data.FileStatus status = new com.assessment.data.FileStatus();
//			  		status.setEmail(emailSentTo);
//			  		status.setStatus(true);
//			  		fileStatusService.saveFileStatus(status);
				incrementSuccessCount();
			} else {
				System.out.println("can't save status");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("problem in sending mail to " + emailSentTo, e);
			if (isSetStatus() && fileStatusService != null) {
//				System.out.println("saving status error");
//		  		com.assessment.data.FileStatus status = new com.assessment.data.FileStatus();
//		  		status.setEmail(emailSentTo);
//		  		status.setStatus(false);
//		  		fileStatusService.saveFileStatus(status);
				incrementFailureCount();
			} else {
				System.out.println("can't save status error");
			}
			throw new AssessmentGenericException("Can not send Email", e);
		}
	}

	public String getEmailSentCC() {
		return emailSentCC;
	}

	public void setEmailSentCC(String emailSentCC) {
		this.emailSentCC = emailSentCC;
	}

	public String[] getCcArray() {
		return ccArray;
	}

	public void setCcArray(String[] ccArray) {
		this.ccArray = ccArray;
	}

	public boolean isSetStatus() {
		return setStatus;
	}

	public void setSetStatus(boolean setStatus) {
		this.setStatus = setStatus;
	}

}

class FromSender {
	String email;

	String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
