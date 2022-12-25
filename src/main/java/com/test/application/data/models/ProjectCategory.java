package com.test.application.data.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author invzbl3 on 12/25/2022
 * @project RestApiApplication
 */
@Entity
public class ProjectCategory {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private Set<Project> projects;

    @CreationTimestamp
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    public ProjectCategory() {
        // TODO Auto-generated constructor stub
    }

    public ProjectCategory(long id) {
        super();
        this.id = id;
    }

    public ProjectCategory(String name) {
        super();
        this.name = name;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Project> getProducts() {
        return projects;
    }

    public void setProducts(Set<Project> projects) {
        this.projects = projects;
    }
}