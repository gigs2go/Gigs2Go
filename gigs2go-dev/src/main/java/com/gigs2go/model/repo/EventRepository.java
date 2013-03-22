package com.gigs2go.model.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.gigs2go.model.entities.Artist;
import com.gigs2go.model.entities.Event;
import com.gigs2go.model.entities.Venue;

public interface EventRepository extends CrudRepository<Event, Long>, QueryDslPredicateExecutor<Event> {
    List<Event> findByDayt ( Date date );

    List<Event> findByArtist ( Artist artist );

    List<Event> findByVenue ( Venue venue );
}
