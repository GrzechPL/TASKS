package com.crud.tasks.service;

<<<<<<< HEAD
import com.crud.tasks.config.AdminConfig;
=======
>>>>>>> 2e957c358e54a0dd1d161787b31b973ac4a10d7c
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

=======
>>>>>>> 2e957c358e54a0dd1d161787b31b973ac4a10d7c
@Service
public class MailCreatorService {

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

<<<<<<< HEAD
    @Autowired
    private AdminConfig adminConfig;

    public String buildTrelloCardEmail(String message){

        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your tasks");
        functionality.add("Provides connection with Trello Account");
        functionality.add("Application allows sending tasks to Trello");


        Context context = new Context();
        context.setVariable("message",message);
        context.setVariable("tasks_url","http://localhost:8888/crud");
        context.setVariable("button","Visit website");
        context.setVariable("admin_name",adminConfig.getAdminName());
        context.setVariable("company", adminConfig.getCompanyName());
        context.setVariable("show_button", false);
        context.setVariable("is_friend", true);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("application_functionality", functionality);

        return templateEngine.process("created-trello-card-mail",context);
=======
    public String buildTrelloCardEmail(String message){
        Context context = new Context();
        context.setVariable("message",message);
        return templateEngine.process("mail/created-trello-card-mail",context);
>>>>>>> 2e957c358e54a0dd1d161787b31b973ac4a10d7c
    }
}
