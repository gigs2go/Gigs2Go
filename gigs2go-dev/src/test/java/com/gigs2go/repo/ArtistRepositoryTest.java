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

import com.gigs2go.model.entities.Artist;
import com.gigs2go.model.repo.ArtistRepository;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( value = "classpath:config/repo.xml" )
@Transactional
public class ArtistRepositoryTest extends AbstractRepoTest {

    private Logger log = Logger.getLogger( ArtistRepositoryTest.class );

    @Autowired
    private ArtistRepository repo;

    @Test
    public void testInject () {
        assertNotNull( repo );
    }

    @Rollback
    @Test
    public void testSaveArtist () {
        log.debug( "Creating artist" );
        Artist user = new Artist();
        user.setName( "testartist" );
        user.setEmail( "testartist@gigs2go.com" );
        user = repo.save( user );
        user = repo.findOne( user.getId() );
        assertNotNull( user );
        assertEquals( "testartist", user.getName() );
        assertEquals( "testartist@gigs2go.com", user.getEmail() );
    }

    @Test
    public void testFindByName () {
        log.debug( "Finding artist by name" );
        List<Artist> users = repo.findByName( "testartist1" );
        assertNotNull( users );
        assertEquals( 1, users.size() );
        assertEquals( "testartist1", users.get( 0 ).getName() );
        assertEquals( "testartist1@gigs2go.com", users.get( 0 ).getEmail() );
    }

    @Test
    public void testFindByEmail () {
        log.debug( "Finding artist by email" );
        List<Artist> users = repo.findByEmail( "testartist3@gigs2go.com" );
        assertNotNull( users );
        assertEquals( 1, users.size() );
        assertEquals( "testartist3", users.get( 0 ).getName() );
        assertEquals( "testartist3@gigs2go.com", users.get( 0 ).getEmail() );
    }

}
