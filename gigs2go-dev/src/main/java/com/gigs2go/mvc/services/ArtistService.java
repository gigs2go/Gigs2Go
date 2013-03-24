/**
 * 
 */
package com.gigs2go.mvc.services;

import java.util.List;

import com.gigs2go.model.entities.Artist;

/**
 * @author tim
 * 
 */
public interface ArtistService {
    Artist getArtistById ( Long id );

    Artist getArtistByName ( String name );

    Artist getArtistByEmail ( String email );

    List<Artist> getArtists ();

    Artist save ( Artist artist );
}
