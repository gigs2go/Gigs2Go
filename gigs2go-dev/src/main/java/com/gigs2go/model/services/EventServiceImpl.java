/**
 * 
 */
package com.gigs2go.model.services;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gigs2go.model.entities.Artist;
import com.gigs2go.model.entities.Event;
import com.gigs2go.model.entities.Venue;
import com.gigs2go.model.repos.EventRepository;

/**
 * @author tim
 * 
 */
@Service( "eventService" )
@Transactional( readOnly = true )
public class EventServiceImpl implements EventService {
    private Logger log = LoggerFactory.getLogger( EventServiceImpl.class );

    @Autowired
    EventRepository repo;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.gigs2go.model.services.EventService#getEventsByDate(java.util.Date)
     */
    public List<Event> getEventsByDate ( LocalDate date ) {
        return repo.findByDate( date );
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.gigs2go.model.services.EventService#getEventsBetween(java.util.Date,
     * java.util.Date)
     */
    public List<Event> getEventsBetween ( LocalDate from, LocalDate to ) {
        return repo.findByDateBetween( from, to );
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.gigs2go.model.services.EventService#getEventsByArtist(com.gigs2go
     * .model.entities.Artist)
     */
    public List<Event> getEventsByArtist ( Artist artist ) {
        return repo.findByArtist( artist );
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.gigs2go.model.services.EventService#getEventsByVenue(com.gigs2go.
     * model.entities.Venue)
     */
    public List<Event> getEventsByVenue ( Venue venue ) {
        return repo.findByVenue( venue );
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.gigs2go.model.services.EventService#save(com.gigs2go.model.entities
     * .Event)
     */
    @Transactional
    public Event save ( Event event ) {
        return repo.save( event );
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.gigs2go.model.services.EventService#getEvents()
     */
    public List<Event> getEvents () {
        List<Event> result = new ArrayList<Event>();

        Iterable<Event> events = repo.findAll();
        for ( Event event : events ) {
            result.add( event );
        }
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.gigs2go.model.services.EventService#getEventById(java.lang.Long)
     */
    public Event getEventById ( Long eventId ) {
        Event result = repo.findOne( eventId );

        return result;
    }

}
