/**
 * 
 */
package com.gigs2go.model.services;

import java.util.List;

import com.gigs2go.model.entities.Venue;

/**
 * @author tim
 * 
 */
public interface VenueService {
    List<Venue> getVenuesByName ( String name );

    List<Venue> getVenuesByTown ( String town );

    Venue getVenueByEmail ( String email );

    List<Venue> getVenues ();

    Venue save ( Venue venue );
}
