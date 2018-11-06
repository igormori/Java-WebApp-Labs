package helperClasses;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class EmailSender {
	




   public static void sendEmail(String fromEmail, String toEmail, String hash, String userName) {    
      // Recipient's email ID needs to be mentioned.
      String to = toEmail;

      // Sender's email ID needs to be mentioned
      String from = fromEmail;

      // Assuming you are sending email from localhost
      String host = "localhost";

      // Get system properties
      Properties properties = System.getProperties();

      // Setup mail server
      properties.setProperty("mail.smtp.host", host);

      // Get the default Session object.
      Session session = Session.getDefaultInstance(properties);

      try {
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         // Set Subject: header field
         message.setSubject("Account Activation!");

         // Now set the actual message
         message.setText("click in the link below to validate your registration: \n http://localhost:8082/Java-Assignment-1-test/EmailValidation?userName="+userName+"&hash="+hash);

         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
      } catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
}


