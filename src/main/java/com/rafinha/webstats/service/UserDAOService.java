package com.rafinha.webstats.service;

import com.rafinha.webstats.jpa.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDAOService {

    @PersistenceContext
    private EntityManager manager;

    public long insertUser(User user) {
        manager.persist(user);
        return user.getId();
    }
}
