package com.test.application.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author invzbl3 on 12/17/2022
 * @project RestApiApplication
 *
 * Postman & browser links for testing purposes:
 *
 * http://localhost:8080/api/page/welcomePage
 * http://localhost:8080/api/page/homePage
 * http://localhost:8080/api/page/userPage
 * http://localhost:8080/api/page/adminPage
 * http://localhost:8080/api/page/loginPage
 * http://localhost:8080/api/page/profilePage
 *
 */
@Controller
@RequestMapping("/api/page")
public class LoginController {

    @GetMapping("/welcomePage")
    public ModelAndView welcomePage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("welcomePage.jsp");
        return model;
    }

    /**
     * Updated homePage.jsp file to provide User and Admin Roles specific activities.
     * homePage.jsp
     */
    @GetMapping("/homePage")
    public ModelAndView homePage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("homePage.jsp");
        return model;
    }

    /**
     * '/userPage' is used by USER Role to access and perform Normal user activities.
     */
    @GetMapping("/userPage")
    public ModelAndView userPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("userPage.jsp");
        return model;
    }

    /**
     * '/adminPage' is used by ADMIN Role to access and perform Admin user activities.
     * ADMIN role can access “/userPage” URL too.
     */
    @GetMapping("/adminPage")
    public ModelAndView adminPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("adminPage.jsp");
        return model;
    }

    @GetMapping("/profilePage")
    public ModelAndView profilePage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("profilePage.jsp");
        return model;
    }

    @GetMapping("/loginPage")
    public ModelAndView loginPage(@RequestParam(value = "error",required = false) String error,
                                  @RequestParam(value = "logout",	required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid Credentials provided.");
        }

        if (logout != null) {
            model.addObject("message", "Logged out from successfully.");
        }

        model.setViewName("loginPage.jsp");
        return model;
    }
}