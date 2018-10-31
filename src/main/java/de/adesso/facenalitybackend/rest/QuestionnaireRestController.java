package de.adesso.facenalitybackend.rest;

import de.adesso.facenalitybackend.business.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionnaireRestController {

    private final QuestionnaireService questionnaireService;

    @Autowired
    public QuestionnaireRestController(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }

    public void save(Long userId,String name) {
        questionnaireService.update(userId, name);
    }

    @RequestMapping("/greet")
    public String greet() {
        return "Hey there!";
    }
}
