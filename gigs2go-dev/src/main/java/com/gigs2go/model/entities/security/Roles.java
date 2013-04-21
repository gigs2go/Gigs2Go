package com.gigs2go.model.entities.security;

import java.io.Serializable;

public interface Roles extends Serializable {
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_USER = "ROLE_USER";
    public static final String ROLE_ARTIST = "ROLE_ARTIST";
    public static final String ROLE_VENUE = "ROLE_VENUE";
    public static final String ROLE_ORGANISER = "ROLE_ORGANISER";

    public static final String[] ADMIN_ROLES = { ROLE_ADMIN, ROLE_USER, ROLE_ARTIST, ROLE_VENUE, ROLE_ORGANISER };
    public static final String[] USER_ROLES = { ROLE_USER };
    public static final String[] ARTIST_ROLES = { ROLE_ARTIST, ROLE_USER };
    public static final String[] VENUE_ROLES = { ROLE_VENUE, ROLE_USER };
    public static final String[] ORGANISER_ROLES = { ROLE_ARTIST, ROLE_VENUE, ROLE_USER };

    public static final String[] ROLES = { ROLE_ADMIN, ROLE_USER, ROLE_ARTIST, ROLE_VENUE, ROLE_ORGANISER };

}
