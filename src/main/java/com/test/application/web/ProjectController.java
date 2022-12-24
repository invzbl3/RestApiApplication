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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

/**
 * @author invzbl3 on 12/20/2022
 * @project RestApiApplication
 *
 * Browser links for testing purposes:
 *
 * http://localhost:8080/api/project/all
 * http://localhost:8080/api/project/{projectId}
 * http://localhost:8080/api/project/ ADD
 * http://localhost:8080/api/project/ UPDATE
 * http://localhost:8080/api/project/ DELETE
 *
 * Example of the structure:
 *
 * {
 *      "name": "Dokazovi"
 *      "abbreviation": "DKZ"
 *      "customer": "SoftServe"
 * }
 */
@RestController
@RequestMapping("/api/project")
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

    @GetMapping("/all")
    @Operation(summary = "Get list of all projects")
    public ResponseEntity<List<ProjectDTO>> findAllProjects() {
        logger.info("findAllProjects() is calling...");

        List<ProjectDTO> projectList = projectService.findAllProjects();
        if (projectList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(projectList, HttpStatus.OK);
    }

    @GetMapping(value = "/{companyId}")
    @Operation(summary = "Get list of projects from database based on companyId")
    public @ResponseBody
    List<ProjectDTO> findAllProjects(@PathVariable("companyId") String companyId,
                                     HttpServletRequest req) throws ErrorHandling {
        logger.info("findAllProjects() is calling : ");
        Long longCompanyId = Long.parseLong(companyId);
        List<Project> projectList = projectService.getAllProjects(longCompanyId);
        logger.info("findAllProjects ProjectList : " + projectList);

        if (projectList != null && !projectList.isEmpty()) {
            return projectAdaptor.databaseModelToUiDtoList(projectList);
        } else {
            throw new ErrorHandling("Project data not present.");
        }
    }

    @PostMapping
    @Operation(summary = "Add new project")
    public ResponseEntity<ProjectDTO> addProject(@RequestBody Project project) {
        logger.info("addProject() is calling...");

        if (project != null) {
            Project entity = projectRepository.save(project);
            ProjectDTO projectDTO = projectAdaptor.databaseModelToUiDto(entity);
            return new ResponseEntity<>(projectDTO, HttpStatus.OK);

        }
        return new ResponseEntity<>(new ProjectDTO("", "", ""), HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    @Operation(summary = "Updating project")
    public ResponseEntity<ProjectDTO> updateById(@RequestBody Project project) {
        logger.info("updateById() is calling...");

        if (project != null) {
            Project entity = projectRepository.save(project);
            ProjectDTO projectDTO = projectAdaptor.databaseModelToUiDto(entity);
            return new ResponseEntity<>(projectDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(new ProjectDTO("", "", ""), HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping
    @Operation(summary = "Deleting project")
    public ResponseEntity<ProjectDTO> deleteById(@PathVariable("id") Long id) {
        logger.info("deleteById() is calling..." + id);

        Optional<Project> project = projectRepository.findById(id);
        if (project.isPresent()) {
            projectRepository.deleteById(id);
            ProjectDTO projectDTO = projectAdaptor.databaseModelToUiDto(project.get());
            return new ResponseEntity<>(projectDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(new ProjectDTO("", "", ""), HttpStatus.BAD_REQUEST);
    }
}