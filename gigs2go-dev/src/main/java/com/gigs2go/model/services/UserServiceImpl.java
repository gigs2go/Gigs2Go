/**
 * 
 */
package com.gigs2go.model.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gigs2go.model.entities.security.Authority;
import com.gigs2go.model.entities.security.User;
import com.gigs2go.model.repos.security.AuthorityRepository;
import com.gigs2go.model.repos.security.UserRepository;

/**
 * @author tim
 * 
 */
@Service( "userService" )
@Transactional( readOnly = true )
public class UserServiceImpl implements UserService {
    private Logger log = LoggerFactory.getLogger( UserServiceImpl.class );

    @Autowired
    UserRepository repo;

    @Autowired
    AuthorityRepository authorityRepo;

    public User getUserByUsername ( String username ) {
        User result = null;
        log.debug( "Finding User(s) with name " + username );
        result = repo.findByUsername( username );

        log.debug( "User result is " + result );
        return result;
    }

    /** Dummy method */
    public User getUserByKey ( String key ) {
        User result = null;
        log.debug( "Finding User(s) with key " + key );
        result = repo.findByUsername( key );

        log.debug( "User result is " + result );
        return result;
    }

    public List<User> getUsers () {
        List<User> result = new ArrayList<User>();

        Iterable<User> users = repo.findAll();
        for ( User user : users ) {
            result.add( user );
        }
        return result;
    }

    @Transactional
    public User save ( User user ) {
        log.debug( "Saving User {}", user );
        Set<Authority> authorities = user.getAuthorities();
        for ( String role : user.getUserType().getRoles() ) {
            log.debug( "Checking role {} for user {}", role, user.getUsername() );
            Authority authority = new Authority();
            authority.setUser( user );
            authority.setAuthority( role );
            if ( !authorities.contains( authority ) ) {
                log.debug( "Adding role {} for user {}", role, user.getUsername() );
                user.getAuthorities().add( authority );
            }
        }
        return repo.save( user );
    }

}
