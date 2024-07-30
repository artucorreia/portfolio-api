package com.portfolio.api.services;

import com.portfolio.api.controllers.ProjectController;
import com.portfolio.api.data.v1.dto.ProjectDTO;
import com.portfolio.api.exceptions.ResourceNotFound;
import com.portfolio.api.mapper.Mapper;
import com.portfolio.api.models.Project;
import com.portfolio.api.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ProjectService {
    private final Logger logger = Logger.getLogger(ProjectService.class.getName());

    @Autowired
    private ProjectRepository repository;

    public ProjectDTO findById(Integer id) {
        logger.info("Find a project by id");

        ProjectDTO project = Mapper.parseObject(
                repository.findById(id).orElseThrow(
                        () -> new ResourceNotFound("No records found for this id!")
                ),
                ProjectDTO.class
        );

        // HATEOAS
        project.add(linkTo(methodOn(ProjectController.class).findById(project.getId())).withSelfRel());
        project.add(linkTo(methodOn(ProjectController.class).findAll()).withRel("all projects"));
        return project;
    }

    public List<ProjectDTO> findAll() {
        logger.info("Find all projects");

        List<Project> entities = repository.findAll();
        List<ProjectDTO> projects = Mapper.parseListObjects(entities, ProjectDTO.class);

        // HATEOAS
        return projects.stream().map(
                project -> project.add(
                        linkTo(
                                methodOn(ProjectController.class).findById(project.getId())
                        ).withSelfRel())
        ).toList();
    }
}
