package email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class CustomizedAuthentication extends Authenticator {
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(MailMetaData.senderMail,	MailMetaData.password);
	    }
}
