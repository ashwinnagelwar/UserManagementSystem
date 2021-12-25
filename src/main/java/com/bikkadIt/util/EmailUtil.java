package com.bikkadIt.util;

import javax.mail.Multipart;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public boolean sendMail(String to, String body, String subject)
	{
		boolean flag=false;
		try
		{
			MimeMessage mimeMessage=javaMailSender.createMimeMessage();
			
			MimeMessageHelper helper=new MimeMessageHelper(mimeMessage);
			helper.setFrom("ashwinnagelwar@gmail.com");
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body);
			
			javaMailSender.send(mimeMessage);
			
			flag=true;
		}
		catch(Exception e)
		{
			
		}
	
		return flag;
	}
	

}
