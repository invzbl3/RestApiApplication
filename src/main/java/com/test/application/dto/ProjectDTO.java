package com.test.application.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.test.application.data.models.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author invzbl3 on 12/20/2022
 * @project RestApiApplication
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class ProjectDTO implements Serializable {

    public ProjectDTO(Project project) {
        this.name = project.getName();
        this.abbreviation = project.getAbbreviation();
        this.customer = project.getCustomer();
    }

    private String name;

    private String abbreviation;

    private String customer;
}