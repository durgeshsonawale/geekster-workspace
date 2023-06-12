package email;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailHandler {
	
	void sendMail() throws MessagingException {
		
		Properties sysProperties= System.getProperties();//gives hashmap
		
		sysProperties.put("mail.smtp.host", MailMetaData.hostServer);
		sysProperties.put("mail.smtp.port", MailMetaData.port);
		sysProperties.put(MailMetaData.sslProperty, "true");
		sysProperties.put(MailMetaData.authPermission, "true");
		
		//create session using email and password
		Authenticator mailAuthenticator=new CustomizedAuthentication();
		
		Session mailSession = Session.getInstance(sysProperties, mailAuthenticator);
		
		//MIME msg
		
		MimeMessage mailMsgMessage= new MimeMessage(mailSession);
		mailMsgMessage.setFrom(MailMetaData.senderMail);
		mailMsgMessage.setSubject("This is my java code testing");
		mailMsgMessage.setText("Hey..this is Durgesh..whats up !!!!");
		
		Address receiverEmailAddress=new InternetAddress("durgeshsonawale8699@gmail.com");
		mailMsgMessage.setRecipient(Message.RecipientType.TO, receiverEmailAddress);
		
		Transport.send(mailMsgMessage);

	} 
}
