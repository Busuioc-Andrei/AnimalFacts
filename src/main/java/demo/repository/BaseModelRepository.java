package demo.repository;

import demo.models.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseModelRepository<T extends BaseModel> extends CrudRepository<T, Long> {
}