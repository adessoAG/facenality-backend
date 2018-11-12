package de.adesso.facenalitybackend.business;

import de.adesso.facenalitybackend.persistence.Questionnaire;
import de.adesso.facenalitybackend.persistence.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.*;

@Service
public class QuestionnaireService {

    private final QuestionnaireRepository questionnaireRepository;

    @Autowired
    public QuestionnaireService(QuestionnaireRepository questionnaireRepository) {
        this.questionnaireRepository = questionnaireRepository;
    }

    public Questionnaire saveQuestionnaire(Questionnaire questionnaire) {
        return questionnaireRepository.save(questionnaire);
    }

    public List<Double> calculateAverage(long id) {
        ArrayList<Double> avgList = new ArrayList<>();

        Optional<Questionnaire> questionnaireOptional = questionnaireRepository.findById(id);
        Questionnaire questionnaire = questionnaireOptional.orElseThrow(EntityNotFoundException::new);

        Set<Map.Entry<String, Integer>> entries = questionnaire.getCattells16Questions().entrySet();
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(entries);

        entryList.sort(Comparator.comparing(Map.Entry::getKey));

        int sum = 0;

        for(int i = 1; i < entryList.size() + 1; i++) {
            sum += entryList.get(i-1).getValue();

            if(i % 10 == 0) {
                double avg = sum / 10.0;
                avgList.add(avg);
                sum = 0;
            }
        }

        return avgList;
    }
}
