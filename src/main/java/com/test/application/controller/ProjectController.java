package com.test.application.controller;

import com.test.application.service.impl.ProjectService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author invzbl3 on 12/15/2022
 * @project RestApiApplication
 */
@Controller
@Data
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/create-project")
    public String createProject(Model model) {
        List<Project> projects = projectService.getAll();
        model.addAttribute();
        model.addAttribute();
        return "";
    }
}
