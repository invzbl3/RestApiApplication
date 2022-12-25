package com.test.application.data.repository;

import com.test.application.data.models.ProjectCategory;
import org.springframework.data.repository.CrudRepository;

/**
 * @author invzbl3 on 12/25/2022
 * @project RestApiApplication
 */
public interface ProjectCategoryRepository extends CrudRepository<ProjectCategory, Long> {
}