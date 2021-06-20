package by.jrr.jdbc.part2.singletable;

import by.jrr.jdbc.part2.mappedsuperclass.MyEmployee;
import by.jrr.jdbc.part2.mappedsuperclass.MyEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private BookRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(by.jrr.jdbc.part2.singletable.Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        repository.save(new Book(1L, "name", "author"));
        System.out.println("book repos");
        repository.save(new Book(2L, "name2", "author2"));
        System.out.println("book repos");
    }
}
