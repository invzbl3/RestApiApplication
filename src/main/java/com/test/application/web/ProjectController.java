package com.test.application.web;

import com.test.application.exception.ErrorHandling;
import com.test.application.service.ProjectService;
import com.test.application.service.adaptor.ProjectAdaptor;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.test.application.data.models.Project;
import com.test.application.dto.ProjectDTO;
import com.test.application.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

/**
 * @author invzbl3 on 12/20/2022
 * @project RestApiApplication
 */
@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    ProjectService projectService;

    ProjectAdaptor projectAdaptor = new ProjectAdaptor();

    /**
     * Logger declaration for knowing the flow of execution for debugging
     */
    private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);

    @GetMapping("/projects")
    @Operation(summary = "Get list of all projects")
    public ResponseEntity<Object> findAllProjects(@RequestBody PageVO pageVo) {
        Pageable pageable = PageRequest.of(pageVo.getStart(), pageVo.getLength(), Sort.Direction.ASC, "id");
        Page<Project> page = projectRepository.findAll(pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @GetMapping(value = "/{companyId}")
    @Operation(summary = "Get list of projects from database based on companyId")
    public @ResponseBody List<ProjectDTO> findAllProjects(@PathVariable("companyId") String companyId,
                                     HttpServletRequest req) throws ErrorHandling {
        logger.info("findAllProjects is calling : ");
        Long longCompanyId = Long.parseLong(companyId);
        List<Project> projectList = projectService.getAllProjects(longCompanyId);
        logger.info("findAllProjects ProjectList : " + projectList);

        if (projectList != null && projectList.size() > 0) {
            return projectAdaptor.databaseModelToUiDtoList(projectList);
        } else {
            throw new ErrorHandling("Project data not present.");
        }
    }

    @PostMapping("/addProject")
    @Operation(summary = "Add new project")
    public ResponseEntity<Object> addProject(@RequestBody Project project) {

        if (project != null) {
            projectRepository.save(project);
            return new ResponseEntity<>("Added successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Add failed.", HttpStatus.OK);
    }

    @PutMapping("/updateProject")
    @Operation(summary = "Updating project")
    public ResponseEntity<Object> updateById(@RequestBody Project project) {
        if (project != null) {
            projectRepository.save(project);
            return new ResponseEntity<>("Updated successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Update failed.", HttpStatus.OK);
    }

    @DeleteMapping("/project/{id}")
    @Operation(summary = "Deleting project")
    public ResponseEntity<Object> deleteById(@PathVariable("id") Long id) {
        Optional<Project> project = projectRepository.findById(id);
        if (project.isPresent()) {
            projectRepository.deleteById(id);
            return new ResponseEntity<>("Successfully deleted.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Delete failed.", HttpStatus.OK);
    }
}