package project.dao;

import java.util.List;

import project.domain.TaskEntity;
import org.springframework.data.repository.CrudRepository;

public interface TaskRep extends CrudRepository<TaskEntity, Long>{

    List<TaskEntity> findAll();

    void deleteById(long id);

    TaskEntity findById(long id);
}
