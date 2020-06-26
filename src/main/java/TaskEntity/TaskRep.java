package TaskEntity;

import java.util.List;

import TaskEntity.ListTasks;

import org.springframework.data.repository.CrudRepository;

public interface TaskRep extends CrudRepository<ListTasks, Long>{

    List<ListTasks> findAll();

    void deleteById(long id);

    ListTasks findById(long id);
}
