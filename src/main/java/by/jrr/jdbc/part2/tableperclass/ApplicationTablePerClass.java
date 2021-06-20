package by.jrr.jdbc.part2.tableperclass;

import by.jrr.jdbc.part2.singletable.Book;
import by.jrr.jdbc.part2.singletable.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationTablePerClass implements CommandLineRunner {

    @Autowired
    private VehicleRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationTablePerClass.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        repository.save(new Vehicle(1L, "boshc"));
        System.out.println("book repos");

    }
}
