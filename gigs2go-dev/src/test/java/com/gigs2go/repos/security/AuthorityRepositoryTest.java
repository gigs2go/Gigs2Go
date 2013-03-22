package com.gigs2go.repos.security;

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

import com.gigs2go.model.entities.security.Authority;
import com.gigs2go.model.entities.security.User;
import com.gigs2go.model.repos.security.AuthorityRepository;
import com.gigs2go.model.repos.security.UserRepository;
import com.gigs2go.repos.AbstractRepoTest;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( value = "classpath:config/repo.xml" )
@Transactional
public class AuthorityRepositoryTest extends AbstractRepoTest {

    private Logger logger = Logger.getLogger( AuthorityRepositoryTest.class );

    @Autowired
    private AuthorityRepository repo;

    @Autowired
    private UserRepository userRepo;

    @Test
    public void testInject () {
        assertNotNull( repo );
    }

    @Rollback
    @Test
    public void testSaveAuthority () {
        logger.debug( "Creating user" );
        User user = new User();
        user.setUsername( "fred" );
        user.setPassword( "password" );
        user = userRepo.save( user );
        logger.debug( "Creating Authority" );
        Authority authority = new Authority();
        authority.setUser( user );
        authority.setAuthority( "ROLE_ADMIN" );
        authority = repo.save( authority );
        List<Authority> authorities = repo.findByUser( user );
        assertNotNull( authorities );
        assertEquals( 1, authorities.size() );
        assertEquals( "fred", authorities.get( 0 ).getUser().getUsername() );
    }

    @Test
    public void testFindByUsername () {
        logger.debug( "Finding authorities" );
        List<Authority> authorities = repo.findByUserUsername( "tim" );
        assertNotNull( authorities );
        assertEquals( 2, authorities.size() );
        Authority authority = authorities.get( 0 );
        assertEquals( "tim", authority.getUser().getUsername() );
    }

}
