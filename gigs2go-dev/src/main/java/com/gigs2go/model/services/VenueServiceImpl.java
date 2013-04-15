/**
 * 
 */
package com.gigs2go.model.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gigs2go.model.entities.Venue;
import com.gigs2go.model.repos.VenueRepository;

/**
 * @author tim
 * 
 */
@Service
@Transactional( readOnly = true )
public class VenueServiceImpl implements VenueService {
    private Logger log = LoggerFactory.getLogger( VenueServiceImpl.class );

    @Autowired
    VenueRepository repo;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.gigs2go.model.services.VenueService#getVenuesByName(java.lang.String)
     */
    public List<Venue> getVenuesByName ( String name ) {
        return repo.findByName( name );
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.gigs2go.model.services.VenueService#getVenuesByTown(java.lang.String)
     */
    public List<Venue> getVenuesByTown ( String town ) {
        return repo.findByAddressTown( town );
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.gigs2go.model.services.VenueService#getVenueByEmail(java.lang.String)
     */
    public Venue getVenueByEmail ( String email ) {
        Venue result = null;
        List<Venue> venues = repo.findByEmailValue( email );

        if ( venues != null && venues.size() > 0 ) {
            if ( venues.size() > 1 ) {
                log.error( "Got more than 1 venue with email " + email );
            }
            result = venues.get( 0 );
        }
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.gigs2go.model.services.VenueService#getVenues()
     */
    public List<Venue> getVenues () {
        List<Venue> result = new ArrayList<Venue>();

        Iterable<Venue> venues = repo.findAll();
        for ( Venue venue : venues ) {
            result.add( venue );
        }
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.gigs2go.model.services.VenueService#save(com.gigs2go.model.entities
     * .Venue)
     */
    public Venue save ( Venue venue ) {
        return repo.save( venue );
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.gigs2go.mvc.services.VenueService#getVenueById(java.lang.String)
     */
    public Venue getVenueById ( Long id ) {
        return repo.findOne( id );
    }

}
