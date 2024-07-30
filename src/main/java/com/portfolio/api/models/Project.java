package com.portfolio.api.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "PROJECTS")
public class Project implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME", length = 50, nullable = false)
    private String name;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "IMAGE_URL", length = 150, nullable = false)
    private String imageUrl;

    @Column(name = "DEPLOY_URL", length = 150, nullable = false)
    private String deployUrl;

    @Column(name = "REPOSITORY_URL", length = 150, nullable = false)
    private String repositoryUrl;

    @Column(name = "ACTIVE", nullable = false)
    private Boolean active;

    public Project() {}

    public Project(Integer id, String name, String description, String imageUrl, String deployUrl, String repositoryUrl, Boolean active) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.deployUrl = deployUrl;
        this.repositoryUrl = repositoryUrl;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDeployUrl() {
        return deployUrl;
    }

    public void setDeployUrl(String deployUrl) {
        this.deployUrl = deployUrl;
    }

    public String getRepositoryUrl() {
        return repositoryUrl;
    }

    public void setRepositoryUrl(String repositoryUrl) {
        this.repositoryUrl = repositoryUrl;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id) && Objects.equals(name, project.name) && Objects.equals(description, project.description) && Objects.equals(imageUrl, project.imageUrl) && Objects.equals(deployUrl, project.deployUrl) && Objects.equals(repositoryUrl, project.repositoryUrl) && Objects.equals(active, project.active);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, imageUrl, deployUrl, repositoryUrl, active);
    }
}
