package ListEntity;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRep extends CrudRepository<ListBooks, Long>{

    List<ListBooks> findAll();

    ListBooks deleteById(long id);

    ListBooks findById(long id);
}

