package com.brewhavensystem.brewhaven.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {
    // Shows to start page at localhost
    @GetMapping("/")
    public String startPage(){
        return "start";
    }

}


