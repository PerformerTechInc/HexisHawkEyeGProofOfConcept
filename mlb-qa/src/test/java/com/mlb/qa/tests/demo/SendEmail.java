package com.mlb.qa.tests.demo;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
//import javax.activation.*;

public class SendEmail
{
   public SendEmail(){
	   
   }
   public void send()
   {    
      // Recipient's email ID needs to be mentioned.
      String to = "igor.vayner@mlb.com";

      // Sender's email ID needs to be mentioned
      String from = "igor.vayner@mlb.com";

      // Assuming you are sending email from localhost
      String host = "10.4.100.36";

      // Get system properties
      Properties properties = System.getProperties();

      // Setup mail server
      properties.setProperty("mail.smtp.host", host);
      //properties.setProperty("mail.smtp.port", "25");

      // Get the default Session object.
      Session session = Session.getDefaultInstance(properties);

      try{
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO,
                                  new InternetAddress(to));

         // Set Subject: header field
         message.setSubject("This is the Subject Line!");

         // Now set the actual message
         message.setText("This is actual message");

         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
}