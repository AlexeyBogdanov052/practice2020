package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TaskEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private long parent_id;
    private String tittle;
    private Boolean done;
    private String date;

    protected TaskEntity() {}

    public TaskEntity(long parent_id, String tittle, Boolean done, String date) {
        this.parent_id = parent_id;
        this.tittle = tittle;
        this.done = done;
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format(
                "ListTasks[parent_id=%d, tittle='%s', done='%b', date='%s']",
                parent_id, tittle, done, date);
    }
}
