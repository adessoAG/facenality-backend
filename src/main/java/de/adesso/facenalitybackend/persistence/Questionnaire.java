package de.adesso.facenalitybackend.persistence;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Questionnaire {

    @Id
    private Long id;
    private String  name;

    public void setName(String name) {
        this.name = name;
    }
}
