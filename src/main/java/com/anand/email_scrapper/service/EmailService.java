package com.anand.email_scrapper.service;

import com.anand.email_scrapper.entity.Email;
import com.anand.email_scrapper.repository.EmailRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailService {
    @Autowired
    EmailRepository emailRepository;

    public void scrapEmails (String url, String companyName) {
        try {
            Document doc =  Jsoup.connect(url).get();
            Elements links = doc.select("a[href]");

            for (Element link: links){
                String href = link.attr("href");

                if(href.startsWith("mailto:")) {
                    String email = href.substring(7);
                    Email newEmail = new Email(companyName, email, url);

                    emailRepository.save(newEmail);
                    System.out.println("Saved Email: " +email);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}