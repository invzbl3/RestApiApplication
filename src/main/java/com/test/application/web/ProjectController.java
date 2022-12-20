package com.test.application.web;

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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author invzbl3 on 12/20/2022
 * @project RestApiApplication
 */
@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    /**
     * Logger declaration for knowing the flow of execution for debugging
     */
    private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);

    /**
     * list of projects
     */
    @GetMapping("/projects")
    @ResponseBody
    public ResponseEntity<Object> findAllProjects(@RequestBody PageVO pageVO) {

        Pageable pageable = PageRequest.of(pageVO.getStart(),pageVO.getLength(), Sort.Direction.ASC,"id");
        Page<Project> page = projectRepository.findAll(pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    /**
     * to get List of projects from database based on companyId
     */
    @RequestMapping(value="/{companyId}", method = RequestMethod.GET)
    public @ResponseBody
    List<ProjectDTO> findAllProjects(@PathVariable("companyId") String companyId,
                                     HttpServletRequest req) throws ErrorHandling {
        logger.info("findAllProjects is calling : " );
        Long longCompanyId = Long.parseLong(companyId);
        List<Project> projectList = projectService.getAllProjects(longcompanyId);
        logger.info("findAllProjects ProjectList : " +projectList);

        if (projectList != null && projectList.size() > 0)
            return projectAdaptor.databaseModelToUiDtoList(projectList);
        else
            throw new ErrorHandling("Project data not present");
    }


    /**
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

    /**
     * updating project
     */
    @PutMapping("/updateProject")
    @ResponseBody
    public ResponseEntity<Object> updateById(@RequestBody Project project) {

        if (project != null) {
            projectRepository.save(project);
            return new ResponseEntity<>("Updated successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Update failed.", HttpStatus.OK);
    }

    /**
     * deleting the project
     */
    @DeleteMapping("/project/{id}")
    @ResponseBody
    public ResponseEntity<Object> deleteById(@PathVariable("id") Integer id) {
        if (id.equals("")) {
            return new ResponseEntity<>("Successfully deleted.", HttpStatus.OK);
        }
        projectRepository.deleteById(id);
        return new ResponseEntity<>("Delete failed.", HttpStatus.OK);
    }
}