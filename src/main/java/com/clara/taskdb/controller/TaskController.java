package com.clara.taskdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by by9506zi on 4/12/2018.
 */

@Controller
public class TaskController {

    @GetMapping("/")
    public String homePage(){
        return "index.html";
    }
}
