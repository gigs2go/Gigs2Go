package com.gigs2go.model.repos.security;

import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.gigs2go.model.entities.security.User;

public interface UserRepository extends CrudRepository<User, String>, QueryDslPredicateExecutor<User> {
	List<User> findByUsername(String username);
}
