package com.test.application.repository;

import com.test.application.data.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author invzbl3 on 12/20/2022
 * @project RestApiApplication
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    public List<Project> findAllByCompanyId(Long companyId);
}