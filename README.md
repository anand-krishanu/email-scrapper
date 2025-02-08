# Email Scraper & Sender

## Overview

This is a Spring Boot-based web application that scrapes email addresses from websites and sends cold emails to them. The application uses JSoup for web scraping and Spring Mail for sending emails.

## Features

- **Scrape Emails**: Extracts email addresses from a given website.
- **Store Emails**: Saves extracted emails in a MySQL database.
- **Send Emails**: Sends customized emails to extracted addresses.
- **Scheduled Scraping**: Can be configured to scrape periodically.

## Tech Stack

- **Backend**: Java (Spring Boot)
- **Database**: MySQL
- **Scraping**: JSoup
- **Email Service**: Spring Mail (SMTP)
- **Dependency Management**: Maven

## Prerequisites

- Java 17+
- MySQL Database
- Maven
- Postman (for API testing)
