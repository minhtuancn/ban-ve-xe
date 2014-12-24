package util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	private static SendEmail instant = new SendEmail();
	private static Session session;
	private static final String USER = "itgroupnlu@gmail.com";
	private static final String PASSWORD = "clbtinhoc";

	private SendEmail() {
		Properties prop = System.getProperties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		Authenticator pa = null;
		pa = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(USER, PASSWORD);
			}
		};
		session = Session.getDefaultInstance(prop, pa);
	}
	
	public static SendEmail getInstant() {
		return instant;
	}
	public void guiMailLienHe(String tenKhachHang,String to, String noiDung ){
		MimeMessage message = new MimeMessage(session);
	     try {
			message.setFrom(new InternetAddress(USER));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
			message.setSubject("Website bán vé xe online!!");
			message.setText("Chào bạn\nBạn vừa gửi mail liên hệ cho công ty chúng tôi với địa chỉ mail là: " + to +
					".\nVới nội dung là:\n" + noiDung+ "\nChúng tôi sẽ trả lời cho bạn trong thời gian sớm nhất!\nChúc bạn ngày mới vui vẻ!");
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		SendEmail.getInstant().guiMailLienHe("Hoang Nhuoc Quy", "12130010@st.hcmuaf.edu.vn", "aaaaaaaaaaaaaaaa");
	}
}
