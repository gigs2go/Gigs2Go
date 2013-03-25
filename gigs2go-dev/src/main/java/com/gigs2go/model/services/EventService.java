/**
 * 
 */
package com.gigs2go.model.services;

import java.util.Date;
import java.util.List;

import com.gigs2go.model.entities.Artist;
import com.gigs2go.model.entities.Event;
import com.gigs2go.model.entities.Venue;

/**
 * @author tim
 * 
 */
public interface EventService {
    List<Event> getEvents ();

    List<Event> getEventsByDate ( Date date );

    List<Event> getEventsBetween ( Date from, Date to );

    List<Event> getEventsByArtist ( Artist artist );

    List<Event> getEventsByVenue ( Venue venue );

    Event save ( Event event );
}
