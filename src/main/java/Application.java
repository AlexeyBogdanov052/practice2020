
import ListEntity.ListBooks;
import TaskEntity.ListTasks;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class);
        ListEntity.BookRep books = context.getBean(ListEntity.BookRep.class);
        TaskEntity.TaskRep tasks = context.getBean(TaskEntity.TaskRep.class);

        books.save(new ListBooks("Домашняя работа"));
        books.save(new ListBooks("Дача"));

        tasks.save(new ListTasks(0, "Починить утюг", false, "21.11"));

        Iterable<ListBooks> allbooks = books.findAll();
        System.out.println("-------------------------------");
        for (ListBooks j : allbooks) {
            System.out.println(j);
        }
        System.out.println();

        ListBooks customer = books.deleteById(1L);
        System.out.println("--------------------------------");
        for (ListBooks j : allbooks) {
            System.out.println(j);
        }
        System.out.println();
    }
}
