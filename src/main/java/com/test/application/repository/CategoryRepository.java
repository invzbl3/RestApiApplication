package com.test.application.repository;

import com.test.application.data.models.Project;
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
    @Query("SELECT p FROM Project p WHERE p.category.id = :categoryId")
    public List<Project> findByCategoryId(@Param("categoryId") Long categoryId);
}