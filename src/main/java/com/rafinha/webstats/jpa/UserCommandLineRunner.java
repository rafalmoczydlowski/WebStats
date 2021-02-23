package com.rafinha.webstats.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserCommandLineRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(UserCommandLineRunner.class);

    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new User("Rafał","Admin"));
        repository.save(new User("Paweł","User"));
        repository.save(new User("Krzysztof","User"));

        for (User user : repository.findAll()) {
            log.info(user.toString());
        }
        log.info("=============================");
        log.info("Website administrators: ");
        for (User user : repository.findByRole("Admin")) {
            log.info(user.toString());
        }
        log.info("=============================");
        log.info("Website users: (alphabetic order)");
        for (User user : repository.findByRoleOrderByName("User")) {
            log.info(user.toString());
        }
    }
}
