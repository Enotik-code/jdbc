package by.jrr.jdbc.part2.joinedtable;

import by.jrr.jdbc.part2.joinedtable.bean.Pet;
import by.jrr.jdbc.part2.joinedtable.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationPet implements CommandLineRunner {

    @Autowired
    private PetRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationPet.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        repository.save(new Pet(1L, "koshka", "murla"));
    }
}
