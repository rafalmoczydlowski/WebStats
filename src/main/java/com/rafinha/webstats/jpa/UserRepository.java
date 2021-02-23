package com.rafinha.webstats.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByRole(String role);
    List<User> findByRoleOrderByName(String role);
}
