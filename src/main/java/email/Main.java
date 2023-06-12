package email;

import javax.mail.MessagingException;

public class Main {

	public static void main(String[] args) throws MessagingException {
		// TODO Auto-generated method stub
		System.out.println("Start sending mail");
		MailHandler mh=new MailHandler();
		mh.sendMail();

	}

}
