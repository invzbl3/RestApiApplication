package com.test.application.service;

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
    ProjectCategoryRepository pcr;

    public void save(ProjectCategory productCategory) {
        pcr.save(productCategory);
    }

    public void delete(Long id){
        pcr.deleteById(id);
    }

    public List<ProjectCategory> get(){
        return (List<ProjectCategory>) pcr.findAll();
    }

    public Optional<ProjectCategory> findById(Long id) {
        return pcr.findById(id);
    }

}
