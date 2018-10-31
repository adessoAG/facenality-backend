package de.adesso.facenalitybackend.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long> {

    Optional<List<Questionnaire>> findByEmail(String email);
}
