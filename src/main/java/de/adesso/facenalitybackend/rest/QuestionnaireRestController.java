package de.adesso.facenalitybackend.rest;

import de.adesso.facenalitybackend.business.QuestionnaireService;
import de.adesso.facenalitybackend.persistence.Questionnaire;
import de.adesso.facenalitybackend.persistence.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;


@CrossOrigin
@RestController
public class QuestionnaireRestController {

    private final QuestionnaireService questionnaireService;

    private final QuestionnaireRepository questionnaireRepository;

    @Autowired
    public QuestionnaireRestController(QuestionnaireService questionnaireService, QuestionnaireRepository repo) {
        this.questionnaireService = questionnaireService;
        this.questionnaireRepository = repo;
    }

    @PostMapping("/save-questionnaire")
    public Long save(@RequestBody Questionnaire questionnaire) {
        return questionnaireService.saveQuestionnaire(questionnaire).getId();
    }

    /**
    @GetMapping("/get")
    public Iterable<Questionnaire> greet() {
        return questionnaireRepository.findAll();
    }
    */


    @GetMapping("/get-test-average/{id}")
    public Iterable<Double> getTestAverageForId(@PathVariable("id") long id) {
        return questionnaireService.calculateAverage(id);
    }

    @RequestMapping(value = "{path:[^\\.]*}")
    public View redirect() {
        // Forward to home page so that route is preserved.
        return new InternalResourceView("/");
    }
}
