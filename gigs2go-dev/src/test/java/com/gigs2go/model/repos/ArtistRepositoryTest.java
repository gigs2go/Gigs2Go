package com.gigs2go.model.repos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.gigs2go.model.entities.Artist;
import com.gigs2go.model.entities.Email;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( value = "classpath:config/repo.xml" )
@Transactional
public class ArtistRepositoryTest extends AbstractRepoTest {

    private Logger log = LoggerFactory.getLogger( ArtistRepositoryTest.class );

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
        user.setEmail( new Email( "testartist@gigs2go.com" ) );
        user = repo.save( user );
        user = repo.findOne( user.getId() );
        assertNotNull( user );
        assertEquals( "testartist", user.getName() );
        assertEquals( "testartist@gigs2go.com", user.getEmail().getValue() );
    }

    @Test
    public void testFindByName () {
        log.debug( "Finding artist by name" );
        List<Artist> users = repo.findByName( "testartist1" );
        assertNotNull( users );
        assertEquals( 1, users.size() );
        assertEquals( "testartist1", users.get( 0 ).getName() );
        assertEquals( "testartist1@gigs2go.com", users.get( 0 ).getEmail().getValue() );
    }

    @Test
    public void testFindByEmailEmail () {
        log.debug( "Finding artist by email" );
        List<Artist> users = repo.findByEmailValue( "testartist3@gigs2go.com" );
        assertNotNull( users );
        assertEquals( 1, users.size() );
        assertEquals( "testartist3", users.get( 0 ).getName() );
        assertEquals( "testartist3@gigs2go.com", users.get( 0 ).getEmail().getValue() );
    }

}
