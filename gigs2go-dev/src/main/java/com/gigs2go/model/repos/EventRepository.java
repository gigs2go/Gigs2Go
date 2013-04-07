package com.gigs2go.model.repos;

import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.gigs2go.model.entities.Artist;
import com.gigs2go.model.entities.Event;
import com.gigs2go.model.entities.Venue;

public interface EventRepository extends CrudRepository<Event, Long>, QueryDslPredicateExecutor<Event> {
    List<Event> findByDate ( LocalDate date );

    List<Event> findByDateBetween ( LocalDate from, LocalDate to );

    List<Event> findByArtist ( Artist artist );

    List<Event> findByVenue ( Venue venue );
}
