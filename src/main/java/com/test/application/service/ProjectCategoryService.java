package com.test.application.service;

import com.test.application.data.models.ProjectCategory;
import com.test.application.data.repository.ProjectCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * @author invzbl3 on 12/25/2022
 * @project RestApiApplication
 */
@Service
public class ProjectCategoryService {

    @Autowired
    ProjectCategoryRepository projectCategoryRepository;

    public void save(ProjectCategory projectCategory) {
        projectCategoryRepository.save(projectCategory);
    }

    public void delete(Long id){
        projectCategoryRepository.deleteById(id);
    }

    public List<ProjectCategory> get(){
        return (List<ProjectCategory>) projectCategoryRepository.findAll();
    }

    public Optional<ProjectCategory> findById(Long id) {
        return projectCategoryRepository.findById(id);
    }
}