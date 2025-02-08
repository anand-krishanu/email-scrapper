package com.anand.email_scrapper.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
public class EmailSendingService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail (String receiver, String subject, String body) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(receiver);
            helper.setSubject(subject);
            helper.setText(body, true);

            javaMailSender.send(message);
            System.out.println("Mail sent to: " + receiver);
        }
        catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
