package de.adesso.facenalitybackend.persistence;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javassist.bytecode.ByteArray;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.awt.*;
import java.sql.Blob;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Entity
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Questionnaire {

    @Id
    @GeneratedValue
    private Long id;

    private String email;

    @Lob
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    @ElementCollection
    private List<String> photos;

    @ElementCollection
    @JsonDeserialize(using = StringMapDeserializer.class)
    private Map<String, Integer> cattells16Questions = new HashMap<>();

    private int age;

    /**
     * @gender :
     * 0 = missed
     * 1 = male
     * 2 = female
     * 3 = other
     */
    private int gender;

    private int timeElapsedInSeconds;



}
