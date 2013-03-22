package com.gigs2go.model.repo.security;

import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.gigs2go.model.entities.security.Authority;
import com.gigs2go.model.entities.security.User;

public interface AuthorityRepository extends CrudRepository<Authority, Integer>, QueryDslPredicateExecutor<Authority> {
    List<Authority> findByUser ( User user );

    List<Authority> findByUserUsername ( String username );
}
