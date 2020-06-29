package project.dao;

import java.util.List;

import project.domain.ListEntity;
import org.springframework.data.repository.CrudRepository;

public interface ListRep extends CrudRepository<ListEntity, Long>{

    List<ListEntity> findAll();

    void deleteById(long id);

    ListEntity findById(long id);
}

