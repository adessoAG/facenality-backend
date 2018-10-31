package de.adesso.facenalitybackend.rest;

import de.adesso.facenalitybackend.business.QuestionnaireService;
import de.adesso.facenalitybackend.persistence.Questionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@CrossOrigin
@RestController
public class QuestionnaireRestController {

    private final QuestionnaireService questionnaireService;

    @Autowired
    public QuestionnaireRestController(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }

    @RequestMapping("/save-questionnaire")
    public Long save(@RequestBody Questionnaire questionnaire) {
        return questionnaireService.saveQuestionnaire(questionnaire).getId();
    }

    @RequestMapping("greet")
    public String greet() {
        return "Hey there :p!";
    }
}
