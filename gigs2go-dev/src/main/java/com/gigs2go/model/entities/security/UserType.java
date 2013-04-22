/**
 * 
 */
package com.gigs2go.model.entities.security;

import java.io.Serializable;

/**
 * @author tim
 * 
 */
public enum UserType implements Roles, Serializable {
    ADMIN( ADMIN_ROLES ), USER( USER_ROLES ), ARTIST( ARTIST_ROLES ), VENUE( VENUE_ROLES ), ORGANISER( ORGANISER_ROLES );

    private String[] roles;

    UserType( String[] roles ) {
        this.roles = roles;
    }

    public boolean isAdmin () {
        return this.equals( UserType.ADMIN );
    }

    public boolean isUser () {
        return this.equals( UserType.USER );
    }

    public boolean isArtist () {
        return this.equals( UserType.ARTIST );
    }

    public boolean isVenue () {
        return this.equals( UserType.VENUE );
    }

    public boolean isOrganiser () {
        return this.equals( UserType.ORGANISER );
    }

    public UserType[] getValues () {
        return UserType.values();
    }

    /**
     * @return the roles
     */
    public String[] getRoles () {
        return this.roles;
    }

    public static UserType[] getRegisterTypes () {
        UserType[] result = { UserType.USER, UserType.ARTIST, UserType.VENUE };
        return result;
    }

}
