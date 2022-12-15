package com.test.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author invzbl3 on 12/14/2022
 * @project RestApiApplication
 */
@Controller
public class HomeController {
    @GetMapping({"/", "/home"})
    public String home() {
        return "index";
    }
}