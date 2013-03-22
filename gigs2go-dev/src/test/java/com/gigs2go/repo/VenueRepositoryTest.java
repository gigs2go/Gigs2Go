package com.gigs2go.repo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.gigs2go.model.entities.Venue;
import com.gigs2go.model.repo.VenueRepository;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( value = "classpath:config/repo.xml" )
@Transactional
public class VenueRepositoryTest extends AbstractRepoTest {

    private Logger log = Logger.getLogger( VenueRepositoryTest.class );

    @Autowired
    private VenueRepository repo;

    @Test
    public void testvenueInject () {
        assertNotNull( repo );
    }

    @Rollback
    @Test
    public void testvenueSaveVenue () {
        log.debug( "Creating venue" );
        Venue venue = new Venue();
        venue.setName( "testvenue" );
        venue.setEmail( "testvenue@gigs2go.com" );
        venue = repo.save( venue );
        venue = repo.findOne( venue.getId() );
        assertNotNull( venue );
        assertEquals( "testvenue", venue.getName() );
        assertEquals( "testvenue@gigs2go.com", venue.getEmail() );
    }

    @Test
    public void testvenueFindByName () {
        log.debug( "Finding venue by name" );
        List<Venue> venues = repo.findByName( "testvenue1" );
        assertNotNull( venues );
        assertEquals( 1, venues.size() );
        assertEquals( "testvenue1", venues.get( 0 ).getName() );
        assertEquals( "testvenue1@gigs2go.com", venues.get( 0 ).getEmail() );
    }

    @Test
    public void testvenueFindByEmail () {
        log.debug( "Finding venue by email" );
        List<Venue> venues = repo.findByEmail( "testvenue3@gigs2go.com" );
        assertNotNull( venues );
        assertEquals( 1, venues.size() );
        assertEquals( "testvenue3", venues.get( 0 ).getName() );
        assertEquals( "testvenue3@gigs2go.com", venues.get( 0 ).getEmail() );
    }

    @Test
    public void testvenueFindByTown () {
        log.debug( "Finding venue by town" );
        List<Venue> venues = repo.findByAddressTown( "Faversham" );
        assertNotNull( venues );
        assertEquals( 2, venues.size() );
        assertEquals( "testvenue2", venues.get( 0 ).getName() );
        assertEquals( "testvenue2@gigs2go.com", venues.get( 0 ).getEmail() );
    }

}
