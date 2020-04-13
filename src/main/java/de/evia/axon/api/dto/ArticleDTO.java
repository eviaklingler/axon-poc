package de.evia.axon.api.dto;


import javax.validation.constraints.NotNull;

public class ArticleDTO {
    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
