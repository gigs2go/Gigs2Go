package com.gigs2go.model.entities.security;

public interface Roles {
	public static final String ROLE_NONE = "ROLE_NONE";
	public static final String ROLE_ADMIN = "ROLE_ADMIN";
	public static final String ROLE_ARTIST = "ROLE_ARTIST";
	public static final String ROLE_EVENT = "ROLE_EVENT";
	public static final String ROLE_VENUE = "ROLE_VENUE";
	public static final String ROLE_USER = "ROLE_USER";
	
	public static final String[] ROLES = { ROLE_NONE, ROLE_ADMIN, ROLE_ARTIST, ROLE_EVENT, ROLE_VENUE, ROLE_USER };

}
