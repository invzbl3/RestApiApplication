package com.test.application.service.impl;

import com.test.application.exception.EntityNotFoundException;
import com.test.application.model.Project;
import com.test.application.repository.ProjectRepository;
import com.test.application.service.ProjectService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author invzbl3 on 12/15/2022
 * @project RestApiApplication
 */
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(("No Project exist for given id")));
    }
}