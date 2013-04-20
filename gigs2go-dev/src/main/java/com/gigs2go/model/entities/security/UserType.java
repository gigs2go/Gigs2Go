/**
 * 
 */
package com.gigs2go.model.entities.security;

import java.io.Serializable;

/**
 * @author tim
 * 
 */
public enum UserType implements Serializable {
    ADMIN, USER, ARTIST, VENUE, ORGANISER;

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

}
