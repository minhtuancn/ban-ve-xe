package util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class abc {
public void send(String from, String to) throws AddressException{
	SendEmail s = SendEmail.getInstant();
	 Properties props = System.getProperties();
	 Session session = Session.getDefaultInstance(props, null);
     MimeMessage message = new MimeMessage(session);
     try {
		message.setFrom(new InternetAddress(from));
		message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(to));
		message.setSubject("Testing Subject");
		Transport.send(message);
	} catch (MessagingException e) {
		e.getMessage();
	}
	 
}
}
