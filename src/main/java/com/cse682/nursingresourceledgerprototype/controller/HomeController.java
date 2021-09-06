package com.cse682.nursingresourceledgerprototype.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for http://localhost:8080/home.
 * Returns index.html
 */
@Controller
public class HomeController {
    @RequestMapping("/home")
    public String home() {
        return "index";
    }
}
