/**
 * 
 */
package com.gigs2go.mvc.converters;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.gigs2go.model.entities.Artist;
import com.gigs2go.model.services.ArtistService;

/**
 * @author tim
 * 
 */
public class StringIdToArtistConverter implements Converter<String, Artist> {
    private Logger log = Logger.getLogger( StringIdToArtistConverter.class );

    @Autowired
    ArtistService service;

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.core.convert.converter.Converter#convert(java.lang
     * .Object)
     */
    public Artist convert ( String id ) {
        Long artistId = Long.valueOf( id );
        return service.getArtistById( artistId );
    }

}
