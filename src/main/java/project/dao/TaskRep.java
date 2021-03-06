package project.dao;

import project.domain.TaskEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRep extends CrudRepository<TaskEntity, Long>{

    TaskEntity findById(long id);
}
