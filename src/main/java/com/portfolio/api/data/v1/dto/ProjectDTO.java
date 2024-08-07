package com.portfolio.api.data.v1.dto;

import org.springframework.hateoas.RepresentationModel;

import java.util.List;

public class ProjectDTO extends RepresentationModel<ProjectDTO> {

    private Long id;

    private String name;

    private String description;

    private String imageUrl;

    private String deployUrl;

    private String repositoryUrl;

    private Boolean active;

    private List<TechnologyDTO> technologies;

    public ProjectDTO() {}

    public ProjectDTO(Long id, String name, String description, String imageUrl, String deployUrl, String repositoryUrl, Boolean active, List<TechnologyDTO> technologies) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.deployUrl = deployUrl;
        this.repositoryUrl = repositoryUrl;
        this.active = active;
        this.technologies = technologies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<TechnologyDTO> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<TechnologyDTO> technologies) {
        this.technologies = technologies;
    }
}
