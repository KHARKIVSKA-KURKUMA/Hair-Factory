package com.m20a20x.hairfactorybackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.m20a20x.hairfactorybackend.payload.ConsultationDTO;

@CrossOrigin
@RestController
public class AppController {

    @Autowired
    @Qualifier("gMailSender")
    private JavaMailSender emailSender;

    @Autowired
    @Qualifier("gMailFrom")
    private String emailFrom;

    @Autowired
    @Qualifier("gMailTo")
    private String emailTo;

    private void sendSimpleMessage(String from, String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    @PostMapping(path = "/enroll", produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> enroll(@RequestBody ConsultationDTO consultationDTO) {

        try {
            final String subject = "hairServiceEnroll from " + consultationDTO.getName()
                    + " " + consultationDTO.getTelephone();
            this.sendSimpleMessage(emailFrom, emailTo, subject, consultationDTO.getQuestion());
            return ResponseEntity.ok("Email succesfully sent to " + emailTo);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}