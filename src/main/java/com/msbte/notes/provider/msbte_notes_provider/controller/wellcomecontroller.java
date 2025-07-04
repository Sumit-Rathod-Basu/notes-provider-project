package com.msbte.notes.provider.msbte_notes_provider.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class wellcomecontroller {

      
     
    @GetMapping("/")
    public String index() {
        return "index"; // Loads templates/index.html
    }

    @GetMapping("/Admin")
    public String showWelcomePage() {
        return "wellcome";  // Renders templates/welcome.html
    }

    @GetMapping("/notess")
    public String showWelcomePage1() {
        return "index";  // Renders templates/welcome.html
    }

    @GetMapping("/go-login")
    public String redirectToLogin() {
        return "login";  // Static page or your login route
    }
}

