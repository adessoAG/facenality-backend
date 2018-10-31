package de.adesso.facenalitybackend.business;

import de.adesso.facenalitybackend.persistence.Questionnaire;
import de.adesso.facenalitybackend.persistence.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionnaireService {

    private final QuestionnaireRepository questionnaireRepository;

    @Autowired
    public QuestionnaireService(QuestionnaireRepository questionnaireRepository) {
        this.questionnaireRepository = questionnaireRepository;
    }


    public void update(Long userId, String name) {
        Optional<Questionnaire> questionnaireOptional = questionnaireRepository.findById(userId);

        questionnaireOptional.ifPresent(questionnaire -> questionnaire.setName(name));
    }
}
