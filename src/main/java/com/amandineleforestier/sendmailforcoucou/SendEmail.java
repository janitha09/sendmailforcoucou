package com.amandineleforestier.sendmailforcoucou;

import java.io.File;
import java.util.*;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//http://www.tutorialspoint.com/java/java_sending_email.htm
//http://stackoverflow.com/questions/3649014/send-email-using-java
public class SendEmail {

    protected static final Logger logger = LoggerFactory.getLogger(SendEmail.class);

    public boolean SendAnEmail(String recipient, String subject, String messagebody) {
        // Recipient's email ID needs to be mentioned.
        String to = recipient;

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
                return new PasswordAuthentication("janitha@amandineleforestier.fr", "coucou&frog");
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
            message.setSubject(subject);
//http://stackoverflow.com/questions/8973026/java-mail-attachments-inline-images
//                    // Handle attachment 1
//        MimeBodyPart messageBodyPart1 = new MimeBodyPart();
//        messageBodyPart1.attachFile("c:/Temp/a.txt");
//
//        // Handle attachment 2
//        MimeBodyPart messageBodyPart2 = new MimeBodyPart();
//        messageBodyPart2.attachFile("c:/Temp/b.txt");

            //inline image
            FileDataSource fileDs = new FileDataSource("C:\\Users\\janitha\\OneDrive\\Pictures\\AW2015\\Adana.jpg");
            MimeBodyPart imageBodypart = new MimeBodyPart();
            imageBodypart.setDataHandler(new DataHandler(fileDs));
            imageBodypart.setHeader("Content-ID", "<myimg>");
            imageBodypart.setDisposition(MimeBodyPart.INLINE);

            MimeMultipart multipart = new MimeMultipart("related"); //mixed

            // Handle text
            String body = "<html><body>Elotte<img src=\"cid:myimg\" width=\"400\" height=\"600\" alt=\"myimg\" />Utana</body></html>";

            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setHeader("Content-Type", "text/plain; charset=\"utf-8\"");
            textPart.setContent(body, "text/html; charset=utf-8");

            multipart.addBodyPart(textPart);
            multipart.addBodyPart(imageBodypart);
//            multipart.addBodyPart(messageBodyPart1);
//            multipart.addBodyPart(messageBodyPart2);

            message.setContent(multipart);
            // Now set the actual message
            //message.setContent(messagebody, "text/html");

            // Send message
            Transport.send(message);
            logger.info("Sent message successfully....");

        } catch (MessagingException mex) {
            logger.error("Could not send message", mex.getMessage());
            return false;
        }
        return true;

    }

//    public boolean sendAnEmailUsingSpring() {
//        JavaMailSenderImpl sender = new JavaMailSenderImpl();
//        sender.setHost("mail.host.com");
//
//        MimeMessage message = sender.createMimeMesage();
//
//// use the true flag to indicate you need a multipart message
//        MimeMessageHelper helper = new MimeMessageHelper(message, true);
//        helper.setTo("test@host.com");
//
//// use the true flag to indicate the text included is HTML
//        helper.setText(
//                "<html><body><img src='cid:identifier1234'></body></html>"
//        true);
//
//// let's include the infamous windows Sample file (this time copied to c:/)
//FileSystemResource res = new FileSystemResource(new File("c:/Sample.jpg"));
//        helper.addInline("identifier1234", res);
//
//// if you would need to include the file as an attachment, use
//// addAttachment() methods on the MimeMessageHelper
//        sender.send(message);
//    }

}
