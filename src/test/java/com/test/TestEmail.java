package com.test;

import java.io.File;

import javax.mail.util.ByteArrayDataSource;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;
import org.junit.Test;

public class TestEmail {
	String msg = "<html>"+
"<header><title>This is title</title></header>"+
"<body>"+
"Hello world"+
"</body>"+
"</html>";
	
	@Test
	public void sendEmail(){
		try{
			HtmlEmail email = new HtmlEmail();
			  String host = "just140.justhost.com";
			 // String from = config.getSendFrom();
			 
			  String from = "jayarama@iiht.co.in";
			  String fromName = "IIHT Admin";
			 // String pass = config.getSendFromPassword();
			  String pass = "Pa$$w0rd@11ht";
			  String smtpPort = "465";
			  email.setHostName(host);
			  email.setSmtpPort(Integer.parseInt(smtpPort));
			 
			  
			  
		  		email.addTo("jatin.sutaria@thev2technologies.com");
		  			
		  		email.setHtmlMsg(msg);
		  		email.setSubject("test");
			  	email.setCharset("UTF-8");
			  
			  email.setFrom(from, fromName);
			 
			  
			 
			  email.setAuthenticator(new DefaultAuthenticator(from, pass)	);
				email.setTLS(false);//change here
				//email.setSmtpPort(Integer.parseInt(smtpPort));
				email.setSSL(true);
				email.setDebug(true);
				
				email.buildMimeMessage();
			
				
				email.sendMimeMessage();
			  System.out.println("Email Sent");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
