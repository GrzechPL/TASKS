package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {

    private static final String SUBJECT = "SecondEmail";

    @Autowired
    private SimpleEmailService simpleEmailService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AdminConfig adminConfig;

    @Scheduled(cron = "0 0 12 * * *")
   // @Scheduled(cron = "*/10 * * * * *")

    public void sendInformationEmail(){

        String oneOrMore = null;
        long size = taskRepository.count();

        if (size == 1){
            oneOrMore ="task";
        }
            else if (size != 1 ){
            oneOrMore ="tasks";
        }
        simpleEmailService.send(new Mail(adminConfig.getAdminMail(),SUBJECT,"Currently in database you got: " + size + " " +oneOrMore));
    }
}


