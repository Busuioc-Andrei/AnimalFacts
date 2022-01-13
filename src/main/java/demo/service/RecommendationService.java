package demo.service;

import demo.models.Animal;
import demo.models.Fact;
import demo.models.Suggestion;
import demo.repository.AnimalRepository;
import demo.repository.FactRepository;
import demo.repository.SuggestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static demo.service.CustomException.badCredentials;

@Service
public class RecommendationService {

    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private FactRepository factRepository;
    @Autowired
    private SuggestionRepository suggestionRepository;

    @Value("${administrator.name}")
    private String adminName;
    @Value("${administrator.password}")
    private String adminPassword;

    @Transactional
    public void makeSuggestion(String animalName, Suggestion suggestion){
        try {
            Optional<Animal> ifExistingAnimal = animalRepository.findByName(animalName);
            if (ifExistingAnimal.isEmpty()) {
                throw CustomException.animalCouldNotBeFound();
            }
            suggestion.setAnimal(ifExistingAnimal.get());
            suggestion.setApproved(false);
            suggestion.setRejected(false);
            suggestion.setCreatedAt(LocalDateTime.now());
            suggestion.setModifiedAt(LocalDateTime.now());
            suggestionRepository.save(suggestion);

        }
        catch (RuntimeException e) {
            if (e instanceof CustomException) {
                throw e;
            } else {
                throw CustomException.suggestionCouldNotBeCreated();
            }
        }
    }

    public List<Suggestion> readQueue(Credentials credentials) {
        checkCredentials(credentials);
        try {
            return suggestionRepository.findAllByApprovedEqualsAndRejectedEquals(false, false);
        }
        catch (RuntimeException e) {
            if (e instanceof CustomException) {
                throw e;
            } else {
                throw CustomException.suggestionCouldNotBeRead();
            }
        }
    }

    @Transactional
    public void approveSuggestion(Credentials credentials, Long suggestionId) {
        checkCredentials(credentials);
        try {
            Optional<Suggestion> ifExistingSuggestion = suggestionRepository.findById(suggestionId);
            if (ifExistingSuggestion.isEmpty()) {
                throw CustomException.suggestionCouldNotBeFound();
            }
            Suggestion suggestion = ifExistingSuggestion.get();
            if (suggestion.getFact() != null){
                throw CustomException.factAlreadyExistsForSuggestion();
            }
            Fact fact = new Fact(suggestion);
            suggestion.setFact(fact);
            suggestion.setRejected(false);
            suggestion.setApproved(true);
            suggestionRepository.save(suggestion);
            factRepository.save(fact);
        }
        catch (RuntimeException e) {
            if (e instanceof CustomException) {
                throw e;
            } else {
                throw CustomException.suggestionCouldNotBeApproved();
            }
        }
    }

    @Transactional
    public void rejectSuggestion(Credentials credentials, Long suggestionId) {
        checkCredentials(credentials);
        try {
            Optional<Suggestion> ifExistingSuggestion = suggestionRepository.findById(suggestionId);
            if (ifExistingSuggestion.isEmpty()) {
                throw CustomException.suggestionCouldNotBeFound();
            }
            Suggestion suggestion = ifExistingSuggestion.get();
            suggestion.setApproved(false);
            suggestion.setRejected(true);
            suggestionRepository.save(suggestion);

        }
        catch (RuntimeException e) {
            if (e instanceof CustomException) {
                throw e;
            } else {
                throw CustomException.suggestionCouldNotBeRejected();
            }
        }
    }


    private void checkCredentials(Credentials credentials) {
        if(!adminName.equals(credentials.getEmail()) || !adminPassword.equals(credentials.getPassword())) {
            throw badCredentials();
        }
    }

}
