package com.fasttrackit.curs21;

import com.fasttrackit.curs21.model.*;
import com.fasttrackit.curs21.repository.AccountRepository;
import com.fasttrackit.curs21.repository.CategoryRepository;
import com.fasttrackit.curs21.repository.TransactionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class Course21CodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(Course21CodeApplication.class, args);
    }

    @Bean
    CommandLineRunner atStartup(TransactionRepository repository, AccountRepository accountRepository, CategoryRepository categoryRepository) {
        return args -> {
            Account stelianAccount = accountRepository.save(new Account("RO3213852131", "Stelian"));
            Account mihaAccount = accountRepository.save(new Account("RO4378129421", "Mihaela"));
            Category electronics = categoryRepository.save(new Category("electronics"));
            Category house = categoryRepository.save(new Category("house"));
            Category christmas = categoryRepository.save(new Category("christmas"));
            Category sale = categoryRepository.save(new Category("sale"));
            Category clothes = categoryRepository.save(new Category("clothes"));
            Category cars = categoryRepository.save(new Category("cars"));

            repository.saveAll(List.of(
                    new Transaction("Laptop", TransactionType.BUY, 3322, new Approval(true, LocalDateTime.now().minusDays(10), "Ana"), listOfNotes(), stelianAccount, List.of(electronics, sale)),
                    new Transaction("Masa", TransactionType.SELL, 322, new Approval(false, LocalDateTime.now().minusMonths(1), "Mihai"), listOfNotes2(), stelianAccount, List.of(house, sale, christmas)),
                    new Transaction("Masina", TransactionType.BUY, 123000, new Approval(false, LocalDateTime.now().minusSeconds(100), "Ana"), listOfNotes3(), stelianAccount, List.of(cars, electronics, house, sale)),
                    new Transaction("Mancare", TransactionType.BUY, 122, new Approval(true, LocalDateTime.now().minusMinutes(32), "Bodan"), listOfNotes(), mihaAccount, List.of(house))
            ));
        };
    }

    private List<Note> listOfNotes() {
        return List.of(new Note("salutare", "Ana"), new Note("prea scump", "Bogdan"));
    }

    private List<Note> listOfNotes2() {
        return List.of(new Note("Hello World", "Rares"), new Note("super tare", "Mihai"), new Note("data viitoare", "Nelu"));
    }

    private List<Note> listOfNotes3() {
        return List.of(new Note("Kaufland", "Ioan"));
    }
}
