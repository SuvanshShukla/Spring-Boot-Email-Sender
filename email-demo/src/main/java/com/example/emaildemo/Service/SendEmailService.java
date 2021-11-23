package com.example.emaildemo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
//import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class SendEmailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleEmail(/*String toEmail, String body, String subject*/) throws Exception {
//        SimpleMailMessage message = new SimpleMailMessage();

        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom("mailtrap@email.com");
        helper.setTo("practice@mail.com");
//        helper.setText("<html><body>Hello! <img src='cid:id101'/> </body></html>");
        helper.setText("<html><body> This is pure HTML BRO!!!</br> <img src='cid:id101'/> </body></html>", true);
        helper.setSubject("waddup bro!");

        ClassPathResource file = new ClassPathResource("cat.jpeg");
        helper.addInline("id101", file);

        mailSender.send(message);
        System.out.println("Mail Sent...");

    }
}
