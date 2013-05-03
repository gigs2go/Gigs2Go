package com.gigs2go.model.repos.security;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.gigs2go.model.entities.security.User;

public interface UserRepository extends CrudRepository<User, Long>, QueryDslPredicateExecutor<User> {
    User findByUsername ( String username );
}
