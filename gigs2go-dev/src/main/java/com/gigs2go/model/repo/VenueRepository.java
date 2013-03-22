package com.gigs2go.model.repo;

import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.gigs2go.model.entities.Venue;

public interface VenueRepository extends CrudRepository<Venue, Long>, QueryDslPredicateExecutor<Venue> {
    List<Venue> findByName ( String name );

    List<Venue> findByEmail ( String email );

    List<Venue> findByAddressTown ( String town );
}
