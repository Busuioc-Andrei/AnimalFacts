package demo.service;

import demo.models.*;
import demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static demo.service.CustomException.*;

@Service
public class CrudService {

    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private FactRepository factRepository;
    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private SuggestionRepository suggestionRepository;


    @Value("${administrator.name}")
    private String adminName;
    @Value("${administrator.password}")
    private String adminPassword;


    @Transactional
    public <T extends BaseModel> void create (T model){
        try {
            BaseModelRepository<T> repository = getRepository(model.getClass());
            model.setCreatedAt(LocalDateTime.now());
            model.setModifiedAt(LocalDateTime.now());
            repository.save(model);
        }
        catch (RuntimeException e) {
            if (e instanceof CustomException) {
                throw e;
            } else {
                throw CustomException.objectCouldNotBeCreated();
            }
        }
    }

    public <T extends BaseModel> T read(Class modelClass, Long id){
        try {
            BaseModelRepository<T> repository = getRepository(modelClass);
            return findIfExists(repository, id);
        }
        catch (RuntimeException e) {
            if (e instanceof CustomException) {
                throw e;
            } else {
                throw CustomException.objectCouldNotBeRead();
            }
        }
    }

    public <T extends BaseModel> List<T> readList(Class modelClass){
        try {
            BaseModelRepository<T> repository = getRepository(modelClass);
            return (List<T>) repository.findAll();
        }
        catch (RuntimeException e) {
            if (e instanceof CustomException) {
                throw e;
            } else {
                throw CustomException.objectCouldNotBeRead();
            }
        }
    }

    @Transactional
    public <T extends BaseModel> void update(T model){
        try {
            BaseModelRepository<T> repository = getRepository(model.getClass());
            T ifExists = findIfExists(repository, model.getId());
            ifExists.update(model);
            repository.save(ifExists);
        }
        catch (RuntimeException e) {
            if (e instanceof CustomException) {
                throw e;
            } else {
                throw CustomException.objectCouldNotBeUpdated();
            }
        }
    }

    @Transactional
    public <T extends BaseModel> void delete(Class modelClass, Long id){
        try {
            BaseModelRepository<T> repository = getRepository(modelClass);
            T ifExists = findIfExists(repository, id);
            repository.delete(ifExists);
        }
        catch (RuntimeException e) {
            if (e instanceof CustomException) {
                throw e;
            } else {
                throw CustomException.objectCouldNotBeDeleted();
            }
        }
    }

//    public Page<BaseModel> findPaginated(Class c, int pageNo, int pageSize) {
//        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
//        return this.getRepository(c).findAll(pageable);
//    }

    private <T extends BaseModel> BaseModelRepository<T> getRepository(Class c){
        if (c == Animal.class)
            return (BaseModelRepository<T>) animalRepository;
        else if (c == Comment.class)
            return (BaseModelRepository<T>) commentRepository;
        else if (c == Fact.class)
            return (BaseModelRepository<T>) factRepository;
        else if (c == Feedback.class)
            return (BaseModelRepository<T>) feedbackRepository;
        else if (c == Image.class)
            return (BaseModelRepository<T>) imageRepository;
        else if (c == Suggestion.class)
            return (BaseModelRepository<T>) suggestionRepository;
        else
            throw CustomException.repositoryCouldNotBeFoundForClass();
    }

    private <T extends BaseModel> T findIfExists(BaseModelRepository<T> repository, Long id){
        Optional<T> ifExisting = repository.findById(id);
        if (ifExisting.isEmpty()) {
            throw CustomException.objectCouldNotBeFound();
        }
        return ifExisting.get();
    }

}
