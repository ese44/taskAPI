package com.clara.taskdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by by9506zi on 4/12/2018.
 */

@Controller
public class TaskController { // create the TaskController class

    @GetMapping("/") //map requests for the home page
    public String homePage(){
        return "index.html";
    }
}
