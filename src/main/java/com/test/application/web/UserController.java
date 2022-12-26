package com.test.application.web;

import com.test.application.data.models.User;
import com.test.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

/**
 * @author invzbl3 on 12/26/2022
 * @project RestApiApplication
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/admin/user/list")
    public ModelAndView list() {
        List<User> userList = userService.get();
        ModelAndView modelAndView = new ModelAndView("/admin/user/list");
        modelAndView.addObject("userList", userList);
        return modelAndView;
    }
}