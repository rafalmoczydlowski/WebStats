package com.rafinha.webstats.jpa;

import com.rafinha.webstats.service.UserDAOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserCommandLineRunner implements CommandLineRunner {

    private static final Logger logOne = LoggerFactory.getLogger(UserCommandLineRunner.class); //first method
    private static final Logger logSecond = LoggerFactory.getLogger(UserDAOService.class); //second method

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserDAOService userDAOService;

    @Override
    public void run(String... args) throws Exception {
        //first method
        repository.save(new User("Rafał","Admin"));
        repository.save(new User("Paweł","User"));
        repository.save(new User("Krzysztof","User"));

        for (User user : repository.findAll()) {
            logOne.info(user.toString());
        }
        logOne.info("=============================");
        logOne.info("Website administrators: ");
        for (User user : repository.findByRole("Admin")) {
            logOne.info(user.toString());
        }
        logOne.info("=============================");
        logOne.info("Website users: (alphabetic order)");
        for (User user : repository.findByRoleOrderByName("User")) {
            logOne.info(user.toString());
        }

        //second method
        User user = new User("Jacek", "User");
        long insert = userDAOService.insertUser(user);
        logSecond.info("New User is created: " + user + " with ID: " + insert);
    }
}
