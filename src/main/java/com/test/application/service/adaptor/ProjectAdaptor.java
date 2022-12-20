package com.test.application.service.adaptor;

import com.test.application.data.models.Project;
import com.test.application.dto.ProjectDTO;
import java.util.ArrayList;
import java.util.List;

/**
 * @author invzbl3 on 12/20/2022
 * @project RestApiApplication
 */
public class ProjectAdaptor implements Adaptor<ProjectDTO, Project> {

    @Override
    public List<Project> uiDtoToDatabaseModelList(List<ProjectDTO> projectDtoList) {
        List<Project> projectList = new ArrayList<>();
        for (ProjectDTO projectDto : projectDtoList) {

            projectList.add(uiDtoToDatabaseModel(projectDto));
        }
        return projectList;
    }

    @Override
    public List<ProjectDTO> databaseModelToUiDtoList(List<Project> projectList) {
        List<ProjectDTO> projectDtoList = new ArrayList<>();
        for (Project project : projectList) {

            projectDtoList.add(databaseModelToUiDto(project));
        }
        return projectDtoList;
    }

    @Override
    public Project uiDtoToDatabaseModel(ProjectDTO projectDto) {
        Project project = new Project();
        project.setName(project.getName());
        project.setAbbreviation(project.getAbbreviation());
        project.setCustomer(project.getCustomer());
        return project;
    }

    @Override
    public ProjectDTO databaseModelToUiDto(Project project) {
        ProjectDTO projectDto = new ProjectDTO();
        projectDto.setName(project.getName());
        projectDto.setAbbreviation(project.getAbbreviation());
        projectDto.setCustomer(project.getCustomer());
        return projectDto;
    }
}