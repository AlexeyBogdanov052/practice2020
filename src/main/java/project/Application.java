package project;

import project.domain.ListEntity;
import project.domain.TaskEntity;
import project.dao.ListRep;
import project.dao.TaskRep;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class);
        /*ListRep books = context.getBean(ListRep.class);
        TaskRep tasks = context.getBean(TaskRep.class);

        books.save(new ListEntity(1L,"Домашняя работа"));
        books.save(new ListEntity(2L,"Дача"));
        books.save(new ListEntity(3L,"List3"));*/

        //tasks.save(new TaskEntity(1L,"Починить утюг"));
    }
}
