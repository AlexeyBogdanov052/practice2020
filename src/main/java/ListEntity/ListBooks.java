package ListEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ListBooks {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String name;

    protected ListBooks() {}

    public ListBooks(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format(
                "ListBooks[id=%d, name='%s']",
                id, name);
    }

}
