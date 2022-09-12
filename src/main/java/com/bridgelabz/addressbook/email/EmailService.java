package com.bridgelabz.addressbook.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    JavaMailSender javaMailSender;
    public void sendEmail(String toMail,String subject,String body)
    {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("shreyasnandish4@gmail.com");
        simpleMailMessage.setTo(toMail);
        simpleMailMessage.setText(body);
        simpleMailMessage.setSubject(subject);

        javaMailSender.send(simpleMailMessage);

    }
}

