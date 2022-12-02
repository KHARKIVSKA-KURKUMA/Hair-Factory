package com.m20a20x.hairfactorybackend.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ConsultationDTO {
    @JsonProperty("user-name")
    private String name;

    @JsonProperty("user-tel")
    private String telephone;

    @JsonProperty("user-question")
    private String question;

    @JsonCreator
    public ConsultationDTO(
            @JsonProperty("user-name") String name,
            @JsonProperty("user-tel") String telephone,
            @JsonProperty("user-question") String question) {
        this.name = name;
        this.telephone = telephone;
        this.question = question;
    }

    public String getName() {
        return name;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getQuestion() {
        return question;
    }
}
