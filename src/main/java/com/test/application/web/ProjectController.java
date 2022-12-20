package com.test.application.web;

import com.test.application.data.models.Project;
import com.test.application.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author invzbl3 on 12/20/2022
 * @project RestApiApplication
 */
@Controller
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    /*
     * list of projects
     */
    @GetMapping("/projects")
    @ResponseBody
    public ResponseEntity<Object> findAllProjects(@RequestBody PageVO pageVO) {

        Pageable pageable = PageRequest.of(pageVO.getStart(),pageVO.getLength(), Sort.Direction.ASC,"id");
        Page<Project> page = projectRepository.findAll(pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    /*
     * new project
     */
    @PostMapping("/addProject")
    @ResponseBody
    public ResponseEntity<Object> addProject(@RequestBody  Project project) {

        if (project != null) {
            projectRepository.save(project);
            return new ResponseEntity<>("Added successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Add failed.", HttpStatus.OK);
    }

    /*
     * editing project
     */
    @PutMapping("/updateProject")
    @ResponseBody
    public ResponseEntity<Object> updateById(@RequestBody Project project) {

        if (project != null) {
            projectRepository.save(project);
            return new ResponseEntity<>("编辑成功", HttpStatus.OK);
        }
        return new ResponseEntity<>("编辑失败", HttpStatus.OK);
    }

    /*
     * deleting the project
     */
    @DeleteMapping("/project/{id}")
    @ResponseBody
    public ResponseEntity<Object> deleteById(@PathVariable("id") Integer id) {
        if (id.equals("")) {
            return new ResponseEntity<>("删除成功", HttpStatus.OK);
        }
        projectRepository.deleteById(id);
        return new ResponseEntity<>("删除成功", HttpStatus.OK);
    }
}