package dao;

import java.util.List;

import domain.ListEntity;
import org.springframework.data.repository.CrudRepository;

public interface ListRep extends CrudRepository<ListEntity, Long>{

    List<ListEntity> findAll();

    void deleteById(long id);

    ListEntity findById(long id);
}

