package com.test.application.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author invzbl3 on 12/14/2022
 * @project RestApiApplication
 */
@RestController
public class HomeController {
    @GetMapping({"/", "/home"})
    public String home() {
        return "index";
    }
}