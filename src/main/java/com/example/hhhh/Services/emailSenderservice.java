package com.example.hhhh.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class emailSenderservice {
    @Autowired
    private JavaMailSender mailsender;

    public void sendEmail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("selim.binous@gmx.com");
        message.setSubject("Shop");
        message.setText("quantité inferieur a 10");

        mailsender.send(message);

    }
}
