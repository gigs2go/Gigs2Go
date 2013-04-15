/**
 * 
 */
package com.gigs2go.model.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.slf4j.Logger; import org.slf4j.LoggerFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.gigs2go.model.entities.Email;
import com.gigs2go.model.entities.Venue;
import com.gigs2go.model.services.VenueService;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( value = "classpath:config/repo.xml" )
@Transactional
public class VenueServiceTest extends AbstractServiceTest {

    private Logger log = LoggerFactory.getLogger( VenueServiceTest.class );

    @Autowired
    private VenueService service;

    @Test
    public void testInject () {
        assertNotNull( service );
    }

    @Rollback
    @Test
    public void testSaveVenue () {
        log.debug( "Creating venue" );
        Venue venue = new Venue();
        venue.setName( "testSaveVenue" );
        venue.setEmail( new Email( "testSaveVenue@gigs2go.com" ) );
        venue = service.save( venue );
        List<Venue> venues = service.getVenuesByName( "testSaveVenue" );
        assertNotNull( venues );
        assertEquals( 1, venues.size() );
        assertEquals( "testSaveVenue", venues.get( 0 ).getName() );
        assertEquals( "testSaveVenue@gigs2go.com", venues.get( 0 ).getEmail().getValue() );
    }

    @Test
    public void testGetVenuesByName1 () {
        List<Venue> venues = service.getVenuesByName( "testvenue2" );
        assertNotNull( venues );
        assertEquals( 1, venues.size() );
        assertEquals( "testvenue2", venues.get( 0 ).getName() );
        assertEquals( "testvenue2@gigs2go.com", venues.get( 0 ).getEmail().getValue() );

    }

    @Test
    public void testGetArtistByName2 () {
        List<Venue> venues = service.getVenuesByName( "testvenue99" );
        assertNotNull( venues );
        assertEquals( 0, venues.size() );
    }

    @Test
    public void testGetVenueByEmail1 () {
        Venue venue = service.getVenueByEmail( "testvenue2@gigs2go.com" );
        assertNotNull( venue );
        assertEquals( "testvenue2", venue.getName() );
        assertEquals( "testvenue2@gigs2go.com", venue.getEmail().getValue() );

    }

    @Test
    public void testGetVenueByEmail2 () {
        Venue venue = service.getVenueByEmail( "testvenue99@gigs2go.com" );
        assertNull( venue );
    }

    @Test
    public void testgetVenues () {
        List<Venue> venues = service.getVenues();
        assertNotNull( venues );
        assertEquals( 4, venues.size() );
    }

}
