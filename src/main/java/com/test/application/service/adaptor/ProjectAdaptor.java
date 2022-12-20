package com.test.application.service.adaptor;

import com.test.application.data.models.Project;
import com.test.application.data.models.Role;
import com.test.application.dto.ProjectDTO;
import java.util.ArrayList;
import java.util.Date;
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
        Groupg groupg = new Groupg();
        Company company = new Company();
        company.setCompanyId(projectDto.getCompanyId());
        project.setCompany(company);
        project.setDateCreated(projectDto.getDateCreated());
        if (projectDto != null) {
            project.setUserId(projectDto.getUserId());
            project.setProjectId(projectDto.getProjectId());
            project.setProjectName(projectDto.getProjectName());
        }
        if (projectDto.getProjectId() == null)
            project.setDateCreated(new Date());
        else
            project.setDateCreated(projectDto.getDateCreated());

        project.setDateUpdate(new Date());
        project.setUserIdUpdate(projectDto.getUserIdUpdate());
        groupg.setGroupId(1L);
        project.setGroupg(groupg);

        Role role = new Role();
        role.setRoleID(projectDto.getRoleId());
        department.setDepartmentName(projectDto.getDepartmentName());
        project.setDepartment(department);
        Client client = new Client();
        client.setClientId(projectDto.getClientId());
        client.setClientName(projectDto.getClientName());
        project.setClient(client);
        return project;
    }

    @Override
    public ProjectDTO databaseModelToUiDto(Project project) {
        ProjectDTO projectDto = new ProjectDTO();
        projectDto.setProjectId(project.getProjectId());
        projectDto.setProjectName(project.getProjectName());
        projectDto.setUserId(project.getUserId());
        projectDto.setDateCreated(project.getDateCreated());
        if (project.getDepartment() != null) {
            projectDto.setDepartmentId(project.getDepartment().getDepartmentId());
            projectDto.setDepartmentName(project.getDepartment().getDepartmentName());
        }

        if (project.getClient() != null) {
            projectDto.setClientId(project.getClient().getClientId());
            projectDto.setClientName(project.getClient().getClientName());
        }
        return projectDto;
    }
}