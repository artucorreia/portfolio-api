package com.portfolio.api.data.v1.dto;

import org.springframework.hateoas.RepresentationModel;

public class SkillDTO extends RepresentationModel<SkillDTO> {

    private Integer id;

    private String name;

    private String imageUrl;

    public SkillDTO() {}

    public SkillDTO(Integer id, String name, String imageUrl) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
