/**
 * 
 */
package com.gigs2go.model.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gigs2go.model.entities.security.User;
import com.gigs2go.model.repos.security.UserRepository;

/**
 * @author tim
 * 
 */
@Service
@Transactional( readOnly = true )
public class UserServiceImpl implements UserService {
    private Logger log = LoggerFactory.getLogger( UserServiceImpl.class );

    @Autowired
    UserRepository repo;

    public User getUserByUsername ( String username ) {
        User result = null;
        log.debug( "Finding User(s) with name " + username );
        result = repo.findByUsername( username );

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
        return repo.save( user );
    }

}
