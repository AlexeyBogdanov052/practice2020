package ListEntity;

import java.util.List;
import ListEntity.ListBooks;

import org.springframework.data.repository.CrudRepository;

public interface ListRep extends CrudRepository<ListBooks, Long>{

    List<ListBooks> findAll();
}

