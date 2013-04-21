package com.gigs2go.model.services;

import java.util.List;

import com.gigs2go.model.entities.security.User;

/**
 * @author tim
 * 
 */
public interface UserService {
    User getUserByUsername ( String username );

    User getUserByKey ( String key );

    List<User> getUsers ();

    User save ( User user );
}
