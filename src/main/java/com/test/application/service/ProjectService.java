package com.test.application.service;

import com.test.application.data.models.Project;
import com.test.application.dto.ProjectDTO;

import java.util.List;

/**
 * @author invzbl3 on 12/20/2022
 * @project RestApiApplication
 */
public interface ProjectService {

    public List<ProjectDTO> getAllProjects();

    public Project save(Project project);

    List<ProjectDTO> findAllProjects();
}