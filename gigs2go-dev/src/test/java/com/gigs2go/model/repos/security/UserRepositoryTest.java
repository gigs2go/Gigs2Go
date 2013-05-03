package com.gigs2go.model.repos.security;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.gigs2go.model.entities.security.User;
import com.gigs2go.model.repos.AbstractRepoTest;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( value = "classpath:config/repo.xml" )
@Transactional
public class UserRepositoryTest extends AbstractRepoTest {

    private Logger log = LoggerFactory.getLogger( UserRepositoryTest.class );

    @Autowired
    private UserRepository repo;

    @Test
    public void testInject () {
        assertNotNull( repo );
    }

    @Rollback
    @Test
    public void testSaveUser () {
        log.debug( "Creating user" );
        User user = new User();
        user.setUsername( "fred" );
        user.setPassword( "password" );
        user = repo.save( user );
        Long userId = user.getId();
        user = null;
        user = repo.findOne( userId );
        assertNotNull( user );
        assertEquals( "fred", user.getUsername() );
        assertEquals( "password", user.getPassword() );
    }

    @Test
    public void testFindUserByUsername () {
        log.debug( "Finding user" );
        User user = repo.findByUsername( "tim@test.com" );
        assertNotNull( user );
        assertEquals( "tim@test.com", user.getUsername() );
    }

}
