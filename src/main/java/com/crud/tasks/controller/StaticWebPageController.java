package com.crud.tasks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class StaticWebPageController {
<<<<<<< HEAD
    @RequestMapping("/")
    public String index (Map<String,Object> model){
        model.put("variable","My Thymeleaf variable");
        model.put("two",2);
=======

    @RequestMapping("/")
    public String index(Map<String,Object> model){
        model.put("variable","My Thymeleaf variable");
        model.put("two",2);

>>>>>>> 767146d6a0870b40a067f96896c2fb1793631361
        return "index";
    }
}
