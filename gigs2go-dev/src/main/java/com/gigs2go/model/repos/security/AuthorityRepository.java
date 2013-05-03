package com.gigs2go.model.repos.security;

import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.gigs2go.model.entities.security.Authority;
import com.gigs2go.model.entities.security.User;

public interface AuthorityRepository extends CrudRepository<Authority, Long>, QueryDslPredicateExecutor<Authority> {
    List<Authority> findByUser ( User user );

    List<Authority> findByUsername ( String username );
}
