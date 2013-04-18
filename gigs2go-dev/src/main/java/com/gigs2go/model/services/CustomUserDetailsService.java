package com.gigs2go.model.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gigs2go.model.entities.security.Authority;
import com.gigs2go.model.entities.security.Roles;
import com.gigs2go.model.repos.security.UserRepository;

//import com.gigs2go.model.entities.security.User;

/**
 * A custom {@link UserDetailsService} where user information is retrieved from
 * a JPA repository
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    Logger log = LoggerFactory.getLogger( CustomUserDetailsService.class );

    /**
     * 
     */
    public CustomUserDetailsService() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Returns a populated {@link UserDetails} object. The username is first
     * retrieved from the database and then mapped to a {@link UserDetails}
     * object.
     */
    public UserDetails loadUserByUsername ( String username ) throws UsernameNotFoundException {
        try {
            log.debug( "Loading User {}", username );

            com.gigs2go.model.entities.security.User domainUser = userRepository.findByUsername( username );

            log.debug( "Found {}", domainUser );
            boolean enabled = true;
            boolean accountNonExpired = true;
            boolean credentialsNonExpired = true;
            boolean accountNonLocked = true;

            Collection<? extends GrantedAuthority> authorities = getAuthorities( domainUser.getAuthorities() );

            log.debug( authorities.toString() );

            UserDetails signedUser = new User( domainUser.getUsername(), domainUser.getPassword().toLowerCase(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities );

            log.debug( signedUser.toString() );

            return signedUser;

        } catch ( Exception e ) {
            log.error( "Login error", e );
            throw new RuntimeException( e );
        }
    }

    /**
     * Retrieves a collection of {@link GrantedAuthority} based on a set of user
     * authorities
     * 
     * @param authorities
     *            the authorities for the user
     * @return a collection of {@link GrantedAuthority}
     */
    public Collection<? extends GrantedAuthority> getAuthorities ( Set<Authority> authorities ) {
        List<String> roles = new ArrayList<String>();
        for ( String role : Roles.ROLES ) {
            roles.add( role );
        }
        // for ( Authority authority : authorities) {
        // roles.add( authority.getAuthority());
        // }
        List<GrantedAuthority> result = getGrantedAuthorities( roles );
        return result;
    }

    /**
     * Converts a numerical role to an equivalent list of roles
     * 
     * @param role
     *            the numerical role
     * @return list of roles as as a list of {@link String}
     */
    public List<String> getRoles ( Integer role ) {
        List<String> roles = new ArrayList<String>();

        if ( role.intValue() == 1 ) {
            roles.add( "ROLE_USER" );
            roles.add( "ROLE_ADMIN" );

        } else if ( role.intValue() == 2 ) {
            roles.add( "ROLE_USER" );
        }

        return roles;
    }

    /**
     * Wraps {@link String} roles to {@link SimpleGrantedAuthority} objects
     * 
     * @param roles
     *            {@link String} of roles
     * @return list of granted authorities
     */
    public static List<GrantedAuthority> getGrantedAuthorities ( List<String> roles ) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for ( String role : roles ) {
            authorities.add( new SimpleGrantedAuthority( role ) );
        }
        return authorities;
    }
}
