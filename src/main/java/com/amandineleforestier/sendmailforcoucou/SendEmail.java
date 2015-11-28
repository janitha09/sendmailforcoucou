package com.amandineleforestier.sendmailforcoucou;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//http://www.tutorialspoint.com/java/java_sending_email.htm
//http://stackoverflow.com/questions/3649014/send-email-using-java

public class SendEmail {
protected static final Logger logger = LoggerFactory.getLogger(SendEmail.class);
    public static void main(String[] args) {
        // Recipient's email ID needs to be mentioned.
        String to = "janitha@amandineleforestier.fr";

        // Sender's email ID needs to be mentioned
        String from = "janitha@amandineleforestier.fr";

        // Assuming you are sending email from localhost
        String host = "smtp.amandineleforestier.fr";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.debug", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.port", "465");
        properties.setProperty("mail.smtp.socketFactory.port", "465");
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.socketFactory.fallback", "false");
//        properties.setProperty("mail.user", "janitha@amandineleforestier.fr");
//        properties.setProperty("mail.password", "coucou&frog");

        // Get the default Session object.
//        Session session = Session.getDefaultInstance(properties);
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("janitha@amandineleforestier.fr", "xxxxxx");
            }
        });
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

            // Now set the actual message
            message.setContent("<h1>This is actual message</h1>", "text/html" );

            // Send message
//            Transport.send(message);
            logger.warn("Sent message successfully....");
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
