/**
 * 
 */
package com.gigs2go.model.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gigs2go.model.entities.Artist;
import com.gigs2go.model.repos.ArtistRepository;

/**
 * @author tim
 * 
 */
@Service
@Transactional( readOnly = true )
public class ArtistServiceImpl implements ArtistService {
    private Logger log = Logger.getLogger( ArtistServiceImpl.class );

    @Autowired
    ArtistRepository repo;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.gigs2go.mvc.services.ArtistService#getArtistByName(java.lang.String)
     */
    public Artist getArtistByName ( String name ) {
        Artist result = null;
        log.debug( "Finding Artist(s) with name " + name );
        List<Artist> artists = repo.findByName( name );

        log.debug( "Artists result is " + artists );
        if ( artists != null && artists.size() > 0 ) {
            if ( artists.size() > 1 ) {
                log.error( "Got more than 1 artist with name " + name );
            }
            result = artists.get( 0 );
        }
        log.debug( "Returning " + result );
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.gigs2go.mvc.services.ArtistService#getArtistByEmail(java.lang.String)
     */
    public Artist getArtistByEmail ( String email ) {
        Artist result = null;
        List<Artist> artists = repo.findByEmailValue( email );

        if ( artists != null && artists.size() > 0 ) {
            if ( artists.size() > 1 ) {
                log.error( "Got more than 1 artist with email " + email );
            }
            result = artists.get( 0 );
        }
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.gigs2go.mvc.services.ArtistService#getArtists()
     */
    public List<Artist> getArtists () {
        List<Artist> result = new ArrayList<Artist>();

        Iterable<Artist> artists = repo.findAll();
        for ( Artist artist : artists ) {
            result.add( artist );
        }
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.gigs2go.mvc.services.ArtistService#save(com.gigs2go.model.entities
     * .Artist)
     */
    @Transactional
    public Artist save ( Artist artist ) {
        return repo.save( artist );
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.gigs2go.mvc.services.ArtistService#getArtistById(java.lang.Long)
     */
    public Artist getArtistById ( Long id ) {
        return repo.findOne( id );
    }

}
