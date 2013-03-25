/**
 * 
 */
package com.gigs2go.mvc.converters;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.gigs2go.model.entities.Venue;
import com.gigs2go.model.services.VenueService;

/**
 * @author tim
 * 
 */
public class StringIdToVenueConverter implements Converter<String, Venue> {
    private Logger log = Logger.getLogger( StringIdToVenueConverter.class );

    @Autowired
    VenueService service;

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.core.convert.converter.Converter#convert(java.lang
     * .Object)
     */
    public Venue convert ( String id ) {
        Long venueId = Long.valueOf( id );
        return service.getVenueById( venueId );
    }

}
