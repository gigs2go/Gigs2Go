/**
 * 
 */
package com.gigs2go.model.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.util.List;

import org.apache.log4j.Logger;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.gigs2go.model.entities.Artist;
import com.gigs2go.model.entities.Event;
import com.gigs2go.model.entities.Venue;
import com.gigs2go.test.Utils;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( value = "classpath:config/repo.xml" )
@Transactional
public class EventServiceTest extends AbstractServiceTest {

    private Logger log = Logger.getLogger( EventServiceTest.class );

    @Autowired
    private EventService service;

    @Autowired
    private ArtistService artistService;

    @Autowired
    private VenueService venueService;

    @Test
    public void testInject () {
        assertNotNull( service );
        assertNotNull( artistService );
        assertNotNull( venueService );
    }

    @Test
    public void testGetEvents () {
        List<Event> events = service.getEvents();
        assertNotNull( events );
        assertEquals( 15, events.size() );
    }

    @Rollback
    @Test
    public void testSaveEvent () {
        log.debug( "Creating event" );
        List<Venue> venues = venueService.getVenuesByName( "testvenue1" );
        assertNotNull( venues );
        assertEquals( 1, venues.size() );
        Venue venue = venues.get( 0 );
        Artist artist = artistService.getArtistByName( "testartist1" );
        assertNotNull( artist );
        Event event = new Event();
        event.setArtist( artist );
        event.setVenue( venue );
        event.setDate( Utils.getDate( "2013-11-29" ) );
        event = service.save( event );
        assertNotNull( event );
        List<Event> events = service.getEvents();
        assertNotNull( events );
        assertEquals( 16, events.size() );
    }

    @Test
    public void testGetEventsByDate () {
        List<Event> events = service.getEventsByDate( Utils.getDate( "2013-03-27" ) );
        assertNotNull( events );
        assertEquals( 3, events.size() );
        assertEquals( "testvenue1", events.get( 0 ).getVenue().getName() );
        assertEquals( "testartist1", events.get( 0 ).getArtist().getName() );
        assertEquals( "testvenue1", events.get( 1 ).getVenue().getName() );
        assertEquals( "testartist2", events.get( 1 ).getArtist().getName() );
        assertEquals( "testvenue1", events.get( 2 ).getVenue().getName() );
        assertEquals( "testartist3", events.get( 2 ).getArtist().getName() );

    }

    @Test
    public void testGetEventsByArtist () {
        Artist artist = artistService.getArtistByName( "testartist1" );
        assertNotNull( artist );
        List<Event> events = service.getEventsByArtist( artist );
        assertNotNull( events );
        assertEquals( 5, events.size() );
    }

    @Test
    public void testGetEventsByVenue () {
        List<Venue> venues = venueService.getVenuesByName( "testvenue1" );
        assertNotNull( venues );
        assertEquals( 1, venues.size() );
        List<Event> events = service.getEventsByVenue( venues.get( 0 ) );
        assertNotNull( events );
        assertEquals( 5, events.size() );
    }

    @Test
    public void testGetEventsByDateBetween () throws ParseException {
        LocalDate from = Utils.getDate( "2013-03-25" );
        LocalDate to = Utils.getDate( "2013-03-27" );
        List<Event> events = service.getEventsBetween( from, to );
        assertNotNull( events );
        assertEquals( 9, events.size() );
    }

    //
    // @Test
    // public void testGetArtistByName2 () {
    // List<Venue> venues = service.getVenuesByName( "testvenue99" );
    // assertNotNull( venues );
    // assertEquals( 0, venues.size() );
    // }
    //
    // @Test
    // public void testGetVenueByEmail1 () {
    // Venue venue = service.getVenueByEmail( "testvenue2@gigs2go.com" );
    // assertNotNull( venue );
    // assertEquals( "testvenue2", venue.getName() );
    // assertEquals( "testvenue2@gigs2go.com", venue.getEmail().getValue() );
    //
    // }
    //
    // @Test
    // public void testGetVenueByEmail2 () {
    // Venue venue = service.getVenueByEmail( "testvenue99@gigs2go.com" );
    // assertNull( venue );
    // }
    //

}
