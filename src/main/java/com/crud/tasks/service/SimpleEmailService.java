package com.crud.tasks.service;

import com.crud.tasks.domain.Mail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class SimpleEmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleMailMessage.class);

    @Autowired
    private JavaMailSender javaMailSender;

<<<<<<< HEAD
   @Autowired
=======
    @Autowired
>>>>>>> 2e957c358e54a0dd1d161787b31b973ac4a10d7c
    private MailCreatorService mailCreatorService;


    public void send(final Mail mail){
        LOGGER.info("Starting email preparation...");

<<<<<<< HEAD
        try {
            //SimpleMailMessage mailMessage = createMailMessage(mail);
            javaMailSender.send(createMimeMessage(mail));
            LOGGER.info("Email has been sent.");
=======
    try {
   // SimpleMailMessage mailMessage = createMailMessage(mail);
    javaMailSender.send(createMimeMessage(mail));
    LOGGER.info("Email has been sent.");
>>>>>>> 2e957c358e54a0dd1d161787b31b973ac4a10d7c
        }
        catch (MailException e){
            LOGGER.error("Failed to process email sending:",e.getMessage(),e);
        }
    }
<<<<<<< HEAD
    private MimeMessagePreparator createMimeMessage(final Mail mail){
=======
        private MimeMessagePreparator createMimeMessage(final Mail mail){
>>>>>>> 2e957c358e54a0dd1d161787b31b973ac4a10d7c
        return mimeMessage ->{
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setTo(mail.getMailTo());
            messageHelper.setSubject(mail.getSubject());
            messageHelper.setText(mailCreatorService.buildTrelloCardEmail(mail.getMessage()),true);
        };
<<<<<<< HEAD

=======
    }
>>>>>>> 2e957c358e54a0dd1d161787b31b973ac4a10d7c
//        private SimpleMailMessage createMailMessage(final Mail mail){
//            SimpleMailMessage mailMessage = new SimpleMailMessage();
//            mailMessage.setTo(mail.getMailTo());
//            mailMessage.setSubject(mail.getSubject());
<<<<<<< HEAD
//            mailMessage.setText(mail.getMessage());
//            return mailMessage;
//        }
}
=======
//            mailMessage.setText(mailCreatorService.buildTrelloCardEmail(mail.getMessage()));
//            return mailMessage;
//        }
>>>>>>> 2e957c358e54a0dd1d161787b31b973ac4a10d7c
}
