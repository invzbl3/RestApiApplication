package com.test.application.service;

import com.test.application.model.Project;
import java.util.List;

/**
 * @author invzbl3 on 12/15/2022
 * @project RestApiApplication
 */
public interface ProjectService {
    List<Project> getAll();

    List<Project> getAllProjects();

    void deleteProject(Long projectId);

    Project updateProject(Project project);

    Project getProjectById(Long projectId);

    Project createProject(Project project);
}