package com.test.application.controller;

import com.test.application.model.Project;
import com.test.application.service.impl.ProjectService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
        model.addAttribute("roles", projects);
        model.addAttribute("user", new Project());
        return "create-project";
    }

    @PostMapping("students/{marathon_id}/add")
    public String createStudent(@PathVariable("marathon_id") long marathonId, @RequestParam("role_id") long roleId,
                                @Validated @ModelAttribute User user, BindingResult result) {
        if (result.hasErrors()) {
            return "create-project";
        }
        user.setRole(roleService.getRoleById(roleId));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        studentService.addUserToMarathon(
                studentService.createOrUpdateUser(user),
                marathonService.getMarathonById(marathonId));
        return "redirect:/students/" + marathonId;
    }

    @GetMapping("students/{marathon_id}/add")
    public String createStudent(@RequestParam("user_id") long userId, @PathVariable("marathon_id") long marathonId) {
        studentService.addUserToMarathon(
                studentService.getUserById(userId),
                marathonService.getMarathonById(marathonId));
        return "redirect:/students/" + marathonId;
    }

    @GetMapping("/students/{marathon_id}/edit/{student_id}")
    public String updateStudent(@PathVariable("marathon_id") long marathonId, @PathVariable("student_id") long studentId, Model model) {
        User user = studentService.getUserById(studentId);
        List<Role> roles = roleService.getAll();
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);
        return "update-student";
    }

    @PostMapping("/students/{marathon_id}/edit/{student_id}")
    public String updateStudent(@PathVariable("marathon_id") long marathonId, @PathVariable("student_id") long studentId,
                                @RequestParam("role_id") long roleId, @Validated @ModelAttribute User user, BindingResult result) {
        if (result.hasErrors()) {
            return "update-marathon";
        }
        user.setRole(roleService.getRoleById(roleId));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        studentService.createOrUpdateUser(user);
        return "redirect:/students/" + marathonId;
    }

    @GetMapping("/students/{marathon_id}/delete/{student_id}")
    public String deleteStudent(@PathVariable("marathon_id") long marathonId, @PathVariable("student_id") long studentId) {
        studentService.deleteUserFromMarathon(
                studentService.getUserById(studentId),
                marathonService.getMarathonById(marathonId));
        return "redirect:/students/" + marathonId;
    }

    @GetMapping("/students")
    public String getAllProjects(Model model) {
        List<Project> projects = projectService.getAll();
        model.addAttribute("projects", projects);
        return "projects";
    }

    @GetMapping("/students/edit/{id}")
    public String updateProject(@PathVariable long id, Model model) {
        Project project = projectService.getUserById(id);
        //List<Role> roles = roleService.getAll();
        model.addAttribute("project", project);
        model.addAttribute("roles", roles);
        return "update-student";
    }

    @PostMapping("/students/edit/{id}")
    public String updateProject(@PathVariable long id, @RequestParam("role_id") long roleId,
                                @Validated @ModelAttribute User user, BindingResult result) {
        if (result.hasErrors()) {
            return "update-marathon";
        }
        user.setRole(roleService.getRoleById(roleId));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        projectService.createOrUpdateUser(user);
        return "redirect:/students";
    }

    @GetMapping("/projects/delete/{id}")
    public String deleteProject(@PathVariable long id) {
        User student = projectService.getProjectById(id);
        for (Marathon marathon : student.getMarathons()) {
            studentService.deleteUserFromMarathon(student, marathon);
        }
        projectService.deleteUserById(id);
        return "redirect:/students";
    }
}