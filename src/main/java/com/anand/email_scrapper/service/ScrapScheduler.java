package com.anand.email_scrapper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScrapScheduler {
    @Autowired
    private EmailService emailService;

    @Scheduled(cron = "0 0 12 * * ?")
    public void scheduleScrap () {
        System.out.println("Starting scheduled scrapping");
        emailService.scrapEmails("https://chhura.com", "Chhura LLC");
    }
}
