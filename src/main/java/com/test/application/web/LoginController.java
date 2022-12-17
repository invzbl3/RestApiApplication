package com.test.application.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author invzbl3 on 12/17/2022
 * @project RestApiApplication
 */
// Postman & browser links for testing purposes:

// http://localhost:8081/api/employee/all
// http://localhost:8081/api/employee/find/{id}
// http://localhost:8081/api/employee/add
// http://localhost:8081/api/employee/update/{id}
// http://localhost:8081/api/employee/delete/{id}
@RestController
public class LoginController {

    @RequestMapping(value = { "/"}, method = RequestMethod.GET)
    public ModelAndView welcomePage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("welcomePage");
        return model;
    }

    /*
     * Updated homePage.jsp file to provide User and Admin Roles specific activities.
     * homePage.jsp
     */
    @RequestMapping(value = { "/homePage"}, method = RequestMethod.GET)
    public ModelAndView homePage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("homePage");
        return model;
    }

    /*
     * '/userPage' is used by USER Role to access and perform Normal user activities.
     */
    @RequestMapping(value = {"/userPage"}, method = RequestMethod.GET)
    public ModelAndView userPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("userPage");
        return model;
    }


    /*
     * '/adminPage' is used by ADMIN Role to access and perform Admin user activities.
     * ADMIN role can access “/userPage” URL too.
     */
    @RequestMapping(value = {"/adminPage"}, method = RequestMethod.GET)
    public ModelAndView adminPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("adminPage");
        return model;
    }

    /*
     *
     */
    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public ModelAndView loginPage(@RequestParam(value = "error",required = false) String error,
                                  @RequestParam(value = "logout",	required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid Credentials provided.");
        }

        if (logout != null) {
            model.addObject("message", "Logged out from JournalDEV successfully.");
        }

        model.setViewName("loginPage");
        return model;
    }
}