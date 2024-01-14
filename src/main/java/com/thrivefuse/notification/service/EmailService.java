package com.thrivefuse.notification.service;

import com.thrivefuse.notification.dto.EmailInfo;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendBulkEmail(EmailInfo info){

      String subject =info.getSubject();
      String textMessage = info.getMessage();
      List<String> toAddressList = info.getToMailAddress();
      for(String toAddress : toAddressList){
          sendSimpleEmail(toAddress,subject,textMessage);
      }

    }

    public void sendSimpleEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("thrivefuse@gmail.com"); // Replace with your email
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }
}

