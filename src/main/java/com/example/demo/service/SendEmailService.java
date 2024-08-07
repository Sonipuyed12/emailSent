package com.example.demo.service;

import com.example.demo.dto.EmailRequestDto;
import com.example.demo.dto.EmailResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("$(spring.mail.username)")
    private  String fromemailId;

    public void sendEmail(EmailRequestDto emailRequestDto) {

        SimpleMailMessage smm = new SimpleMailMessage();

        smm.setFrom(fromemailId);
        smm.setTo(emailRequestDto.getRecipients());
        smm.setText(emailRequestDto.getBody());
        smm.setSubject(emailRequestDto.getSubject());
        javaMailSender.send(smm);

    }

}
