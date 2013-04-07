/**
 * 
 */
package com.gigs2go.model.services;

import java.util.List;

import org.joda.time.LocalDate;

import com.gigs2go.model.entities.Artist;
import com.gigs2go.model.entities.Event;
import com.gigs2go.model.entities.Venue;

/**
 * @author tim
 * 
 */
public interface EventService {
    List<Event> getEvents ();

    Event getEventById ( Long eventId );

    List<Event> getEventsByDate ( LocalDate date );

    List<Event> getEventsBetween ( LocalDate from, LocalDate to );

    List<Event> getEventsByArtist ( Artist artist );

    List<Event> getEventsByVenue ( Venue venue );

    Event save ( Event event );
}
