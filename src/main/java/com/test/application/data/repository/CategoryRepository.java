package com.test.application.data.repository;

import com.test.application.data.models.Project;
import com.test.application.dto.ProjectDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

/**
 * @author invzbl3 on 12/25/2022
 * @project RestApiApplication
 */
public interface CategoryRepository extends CrudRepository<Project, Long> {

    // find by category id
    @Query("SELECT p FROM project_entity p WHERE p.category.id = :categoryId")
    public List<ProjectDTO> findByCategoryId(@Param("categoryId") Long categoryId);
}