package com.portfolio.api.services;

import com.portfolio.api.controllers.SkillController;
import com.portfolio.api.data.v1.dto.SkillDTO;
import com.portfolio.api.exceptions.ResourceNotFound;
import com.portfolio.api.mapper.Mapper;
import com.portfolio.api.models.Skill;
import com.portfolio.api.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class SkillService {
    private final Logger logger = Logger.getLogger(SkillService.class.getName());

    @Autowired
    private SkillRepository repository;

    public SkillDTO findById(Long id) {
        logger.info("Find a skill by id");

        SkillDTO skill = Mapper.parseObject(
                repository.findById(id).orElseThrow(
                        () -> new ResourceNotFound("No records found for this id!")
                ),
                SkillDTO.class
        );

        // HATEOAS
        skill.add(linkTo(methodOn(SkillController.class).findById(skill.getId())).withSelfRel());
        skill.add(linkTo(methodOn(SkillController.class).findAll()).withRel("all skills"));
        return skill;
    }

    public List<SkillDTO> findAll() {
        logger.info("Find all skills");

        List<Skill> entities = repository.findAll();
        List<SkillDTO> skills = Mapper.parseListObjects(entities, SkillDTO.class);

        // HATEOAS
        return skills.stream().map(
                skill -> skill.add(
                        linkTo(
                                methodOn(SkillController.class).findById(skill.getId())
                        ).withSelfRel())
        ).toList();
    }
}
