/**
 * 
 */
package com.gigs2go.model.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
import com.gigs2go.model.entities.Email;
import com.gigs2go.model.services.ArtistService;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( value = "classpath:config/repo.xml" )
@Transactional
public class ArtistServiceTest extends AbstractServiceTest {

    private Logger log = Logger.getLogger( ArtistServiceTest.class );

    @Autowired
    private ArtistService service;

    @Test
    public void testInject () {
        assertNotNull( service );
    }

    @Rollback
    @Test
    public void testSaveArtist () {
        log.debug( "Creating artist" );
        Artist artist = new Artist();
        artist.setName( "testSaveArtist" );
        artist.setEmail( new Email( "testSaveArtist@gigs2go.com" ) );
        artist = service.save( artist );
        artist = service.getArtistByName( "testSaveArtist" );
        assertNotNull( artist );
        assertEquals( "testSaveArtist", artist.getName() );
        assertEquals( "testSaveArtist@gigs2go.com", artist.getEmail().getValue() );
    }

    @Test
    public void testGetArtistByName1 () {
        Artist artist = service.getArtistByName( "testartist2" );
        assertNotNull( artist );
        assertEquals( "testartist2", artist.getName() );
        assertEquals( "testartist2@gigs2go.com", artist.getEmail().getValue() );

    }

    @Test
    public void testGetArtistByName2 () {
        Artist artist = service.getArtistByName( "testartist99" );
        assertNull( artist );
    }

    @Test
    public void testGetArtistByEmail1 () {
        Artist artist = service.getArtistByEmail( "testartist2@gigs2go.com" );
        assertNotNull( artist );
        assertEquals( "testartist2", artist.getName() );
        assertEquals( "testartist2@gigs2go.com", artist.getEmail().getValue() );

    }

    @Test
    public void testGetArtistByEmail2 () {
        Artist artist = service.getArtistByEmail( "testartist99@gigs2go.com" );
        assertNull( artist );
    }

    @Test
    public void testgetArtists () {
        List<Artist> artists = service.getArtists();
        assertNotNull( artists );
        assertEquals( 4, artists.size() );
    }

}
