package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ListEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String name;

    protected ListEntity() {}

    public ListEntity(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format(
                "ListBooks[id=%d, name='%s']",
                id, name);
    }

}
