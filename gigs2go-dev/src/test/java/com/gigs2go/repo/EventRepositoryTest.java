package com.gigs2go.repo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
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
import com.gigs2go.model.repo.ArtistRepository;
import com.gigs2go.model.repo.EventRepository;
import com.gigs2go.model.repo.VenueRepository;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( value = "classpath:config/repo.xml" )
@Transactional
public class EventRepositoryTest extends AbstractRepoTest {

    private Logger log = Logger.getLogger( EventRepositoryTest.class );

    @Autowired
    private EventRepository repo;

    @Autowired
    private ArtistRepository artistRepo;

    @Autowired
    private VenueRepository venueRepo;

    private Date now = new Date();

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
        event.setDayt( now );
        event = repo.save( event );
        event = repo.findOne( event.getId() );
        assertNotNull( event );
        assertEquals( artist, event.getArtist() );
        assertEquals( venue, event.getVenue() );
        assertEquals( now, event.getDayt() );
    }

    @Test
    public void testFindByDate () throws ParseException {
        List<Event> events = repo.findByDayt( new SimpleDateFormat( "yyyy-MM-dd" ).parse( "2013-03-28" ) );
        assertNotNull( events );
        assertEquals( 1, events.size() );
        ;
    }

}
