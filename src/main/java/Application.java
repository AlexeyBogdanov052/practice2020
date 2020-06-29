
import domain.ListEntity;
import domain.TaskEntity;
import dao.ListRep;
import dao.TaskRep;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class);
        ListRep books = context.getBean(ListRep.class);
        TaskRep tasks = context.getBean(TaskRep.class);

        books.save(new ListEntity("Домашняя работа"));
        books.save(new ListEntity("Дача"));

        tasks.save(new TaskEntity(0, "Починить утюг"));

        Iterable<ListEntity> allbooks = books.findAll();
        System.out.println("-------------------------------");
        for (ListEntity j : allbooks) {
            System.out.println(j);
        }
        System.out.println();

        books.deleteById(1L);
        System.out.println("--------------------------------");
        for (ListEntity j : allbooks) {
            System.out.println(j);
        }
        System.out.println();
    }
}
