package com.test.application.web;

import com.test.application.data.models.ProjectCategory;
import com.test.application.dto.ProjectDTO;
import com.test.application.service.ProjectCategoryService;
import com.test.application.service.ProjectService;
import com.test.application.service.impl.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
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
    ProjectServiceImpl projectServiceImpl;

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
        List<ProjectDTO> projectList;
        List<ProjectCategory> projectCategoryList = categoryService.get();
        if (categoryId.isPresent()) {
            projectList = projectServiceImpl.findByCategoryId(categoryId.get());
        } else {
            projectList = projectService.findAllProjects();
        }
        ModelAndView modelAndView = new ModelAndView("customer/home");
        modelAndView.addObject("projectList", projectList);
        modelAndView.addObject("projectCategoryList", projectCategoryList);
        modelAndView.addObject("categoryId", categoryId);
        return modelAndView;
    }
}