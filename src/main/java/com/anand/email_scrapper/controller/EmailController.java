package com.anand.email_scrapper.controller;

import com.anand.email_scrapper.entity.Email;
import com.anand.email_scrapper.repository.EmailRepository;
import com.anand.email_scrapper.service.EmailSendingService;
import com.anand.email_scrapper.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class EmailController {
    @Autowired
    EmailService emailService;

    @Autowired
    EmailRepository emailRepository;

    @Autowired
    EmailSendingService sendingService;

    @PostMapping("/scrape")
    public String scrape (@RequestParam String url, @RequestParam String company) {
        emailService.scrapEmails(url, company);
        return "Scraping started for: " + company;
    }

    @GetMapping("/sendAllEmails")
    public void sendEmailsToAll() {
        List<Email> emails = emailRepository.findAll();
        for (Email email : emails) {
            sendingService.sendEmail(email.getEmail(), "Test Subject", "Test Body");
        }
    }

    @GetMapping("/getAllEmails")
    public List<Email> getAllEmails () {
        return emailRepository.findAll();
    }

    @PostMapping("sendEmails")
    public void sendEmail (@RequestParam String receiver, @RequestParam String subject, @RequestParam String body) {
        sendingService.sendEmail(receiver, subject, body);
    }
}