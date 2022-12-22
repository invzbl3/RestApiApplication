package com.test.application.service.impl;

import com.test.application.data.models.Project;
import com.test.application.dto.ProjectDTO;
import com.test.application.repository.ProjectRepository;
import com.test.application.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author invzbl3 on 12/20/2022
 * @project RestApiApplication
 */
@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> getAll() {
        return projectRepository.getAll();
    }

    @Override
    public List<Project> getAllProjects(Long companyId) {
        return projectRepository.getAll().stream()
                .filter(project -> project.getId() == companyId).findAny().orElse(null);
    }

    @Override
    public Project save(Project project) {
        return null;
    }

    @Override
    public List<ProjectDTO> findAllProducts() {
        return null;
    }
}