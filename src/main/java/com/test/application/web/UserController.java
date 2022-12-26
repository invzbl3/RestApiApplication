package com.test.application.web;

import com.test.application.data.models.User;
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

    /**
     * This Get api is responsible to view User List
     * @return ModelAndView
     */
    @GetMapping("/admin/user/list")
    public ModelAndView list() {
        List<User> uList = userService.get();
        ModelAndView modelAndView = new ModelAndView("/admin/user/list");
        modelAndView.addObject("uList", uList);
        return modelAndView;
    }
}