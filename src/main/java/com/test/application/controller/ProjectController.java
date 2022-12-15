package com.test.application.controller;

import com.test.application.model.Project;
import com.test.application.service.ProjectService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author invzbl3 on 12/15/2022
 * @project RestApiApplication
 */
@Data
@RestController
@AllArgsConstructor
@RequestMapping("api/projects")
public class ProjectController {

    private ProjectService projectService;

    // build create Project REST API
    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        Project savedProject = projectService.createProject(project);
        return new ResponseEntity<>(savedProject, HttpStatus.CREATED);
    }

    // build get user by id REST API
    // http://localhost:8080/api/projects/1
    @GetMapping("{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable("id") Long projectId) {
        Project project = projectService.getProjectById(projectId);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    // Build Get All Projects REST API
    // http://localhost:8080/api/projects
    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    // Build Update Project REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/projects/1
    public ResponseEntity<Project> updateProject(@PathVariable("id") Long projectId,
                                                 @RequestBody Project project) {
        project.setId(projectId);
        Project updatedProject = projectService.updateProject(project);
        return new ResponseEntity<>(updatedProject, HttpStatus.OK);
    }

    // Build Delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProject(@PathVariable("id") Long projectId) {
        projectService.deleteProject(projectId);
        return new ResponseEntity<>("Project successfully deleted!", HttpStatus.OK);
    }
}