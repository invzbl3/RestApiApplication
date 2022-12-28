package com.test.application.service.impl;

import com.test.application.data.models.Project;
import com.test.application.dto.ProjectDTO;
import com.test.application.data.repository.CategoryRepository;
import com.test.application.data.repository.ProjectRepository;
import com.test.application.service.ProjectService;
import com.test.application.service.adaptor.ProjectAdaptor;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProjectAdaptor projectAdaptor;

    @Override
    public List<ProjectDTO> getAllProjects(Long companyId) {
        List<Project> project = projectRepository.findAllByCompanyId(companyId);
        return projectAdaptor.databaseModelToUiDtoList(project);
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

    public List<ProjectDTO> findByCategoryId(Long categoryId) {
        return categoryRepository.findByCategoryId(categoryId);
    }

    public List<Project> get(){
        return (List<Project>) categoryRepository.findAll();
    }
}