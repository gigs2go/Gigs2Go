package com.gigs2go.model.repos;

import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.gigs2go.model.entities.Artist;

public interface ArtistRepository extends CrudRepository<Artist, Long>, QueryDslPredicateExecutor<Artist> {
    List<Artist> findByName ( String name );

    List<Artist> findByEmailValue ( String email );
}
