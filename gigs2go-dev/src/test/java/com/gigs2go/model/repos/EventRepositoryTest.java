package com.gigs2go.model.repos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger; import org.slf4j.LoggerFactory;
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
public class EventRepositoryTest extends AbstractRepoTest {

    private Logger log = LoggerFactory.getLogger( EventRepositoryTest.class );

    @Autowired
    private EventRepository repo;

    @Autowired
    private ArtistRepository artistRepo;

    @Autowired
    private VenueRepository venueRepo;

    private LocalDate now = new LocalDate();

    @Test
    public void testeventInject () {
        assertNotNull( repo );
    }

    @Rollback
    @Test
    public void testSaveEvent () {
        log.debug( "Creating event" );
        Event event = new Event();
        Artist artist = artistRepo.findOne( 1L );
        Venue venue = venueRepo.findOne( 1L );
        event.setArtist( artist );
        event.setVenue( venue );
        event.setDate( now );
        event = repo.save( event );
        event = repo.findOne( event.getId() );
        assertNotNull( event );
        assertEquals( artist, event.getArtist() );
        assertEquals( venue, event.getVenue() );
        assertEquals( now, event.getDate() );
    }

    @Test
    public void testFindByDate () throws ParseException {
        List<Event> events = repo.findByDate( Utils.getDate( "2013-03-28" ) );
        assertNotNull( events );
        assertEquals( 3, events.size() );
        Event event = events.get( 0 );
        assertEquals( "testartist1", event.getArtist().getName() );
        assertEquals( "testvenue1", event.getVenue().getName() );

    }

    @Test
    public void testFindByDateBetween () throws ParseException {
        LocalDate from = Utils.getDate( "2013-03-25" );
        LocalDate to = Utils.getDate( "2013-03-27" );
        List<Event> events = repo.findByDateBetween( from, to );
        assertNotNull( events );
        assertEquals( 9, events.size() );
    }

}
