package com.test.application.service.impl;

import com.test.application.data.models.Project;
import com.test.application.dto.ProjectDTO;
import com.test.application.repository.ProjectRepository;
import com.test.application.service.ProjectService;
import com.test.application.service.adaptor.ProjectAdaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author invzbl3 on 12/20/2022
 * @project RestApiApplication
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectAdaptor projectAdaptor;

    @Override
    public List<Project> getAllProjects(Long companyId) {
        return projectRepository.findAll().stream()
                .filter(project -> Objects.equals(project.getId(), companyId))
                .collect(Collectors.toList());
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public List<ProjectDTO> findAllProjects() {
        List<Project> project = projectRepository.findAll();
        return projectAdaptor.databaseModelToUiDtoList(project);
    }
}