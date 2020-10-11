package com.yyhn.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import sun.net.www.http.HttpClient;

import java.io.File;

@Service
public class MailService {
    @Autowired(required =false)
    JavaMailSender mailSender;

    public void sendMail(String from , String to , String cc, String subject,String content){
      SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
      simpleMailMessage.setFrom(from);
      simpleMailMessage.setTo(to);
      //simpleMailMessage.setCc(cc);
      simpleMailMessage.setSubject(subject);
      simpleMailMessage.setText(content);
      mailSender.send(simpleMailMessage);
    }
}
