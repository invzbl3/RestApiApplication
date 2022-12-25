package com.test.application.web;

import com.test.application.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author invzbl3 on 12/14/2022
 * @project RestApiApplication
 */
@Controller
public class HomeController {
    @Autowired
    ProjectService projectService;

    @Autowired
    ProjectCategoryService categoryService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/customer")
    public ModelAndView customerHome(
            @RequestParam("categoryId") Optional<Long> categoryId
    ) {
        List<Project> pList = new ArrayList<Project>();
        List<ProjectCategory> pcList = categoryService.get();
        if (categoryId.isPresent()) {
            pList = projectService.findByCategoryId(categoryId.get());
        } else {
            pList = projectService.get();
        }
        ModelAndView modelAndView = new ModelAndView("customer/home");
        modelAndView.addObject("pList", pList);
        modelAndView.addObject("pcList", pcList);
        modelAndView.addObject("categoryId", categoryId);
        return modelAndView;
    }
}