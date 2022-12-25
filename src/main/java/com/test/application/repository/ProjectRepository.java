package com.test.application.repository;

import com.test.application.data.models.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * @author invzbl3 on 12/20/2022
 * @project RestApiApplication
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    public List<Project> findAllByCompanyId(Long companyId);
}