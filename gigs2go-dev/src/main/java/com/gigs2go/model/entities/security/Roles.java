package com.gigs2go.model.entities.security;

import java.io.Serializable;

public interface Roles extends Serializable {
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_ARTIST = "ROLE_ARTIST";
    public static final String ROLE_EVENT = "ROLE_EVENT";
    public static final String ROLE_VENUE = "ROLE_VENUE";
    public static final String ROLE_USER = "ROLE_USER";
    public static final String ROLE_ADD = "ROLE_ADD";
    public static final String ROLE_DELETE = "ROLE_DELETE";

    public static final String[] ROLES = { ROLE_ADMIN, ROLE_ARTIST, ROLE_EVENT, ROLE_VENUE, ROLE_USER, ROLE_ADD, ROLE_DELETE };

}
