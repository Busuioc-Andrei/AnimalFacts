package demo.repository;

import demo.models.BaseModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseModelRepository<T extends BaseModel> extends CrudRepository<T, Long> {
    Page<BaseModel> findAll(Pageable pageable);
}