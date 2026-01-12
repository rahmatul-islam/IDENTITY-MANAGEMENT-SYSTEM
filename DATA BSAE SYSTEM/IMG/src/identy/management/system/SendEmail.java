package identy.management.system;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class SendEmail {
    public static void sendOTP(String to, String otp) {
        String from = "yourEmail@gmail.com"; // তোমার Gmail
        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("javaotp2@gmail.com", "ahyj wmxu fczb lmso");
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Your OTP Code");
            message.setText("Your OTP is: " + otp);

            Transport.send(message);
            System.out.println("OTP sent successfully...");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}