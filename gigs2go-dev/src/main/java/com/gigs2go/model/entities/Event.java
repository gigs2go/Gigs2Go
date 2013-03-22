/**
 * 
 */
package com.gigs2go.model.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.log4j.Logger;

/**
 * @author tim
 * 
 */
@Entity
@Table( name = "events" )
public class Event {
    @Transient
    private Logger log = Logger.getLogger( Event.class );

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;

    @ManyToOne
    private Artist artist;

    @ManyToOne
    private Venue venue;

    @Temporal( value = TemporalType.DATE )
    private Date dayt;

    /**
     * @return the dayt
     */
    public Date getDayt () {
        return this.dayt;
    }

    /**
     * @param dayt
     *            the dayt to set
     */
    public void setDayt ( Date dayt ) {
        this.dayt = dayt;
    }

    /**
     * @return the id
     */
    public Long getId () {
        return this.id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId ( Long id ) {
        this.id = id;
    }

    /**
     * @return the artist
     */
    public Artist getArtist () {
        return this.artist;
    }

    /**
     * @param artist
     *            the artist to set
     */
    public void setArtist ( Artist artist ) {
        this.artist = artist;
    }

    /**
     * @return the venue
     */
    public Venue getVenue () {
        return this.venue;
    }

    /**
     * @param venue
     *            the venue to set
     */
    public void setVenue ( Venue venue ) {
        this.venue = venue;
    }

}
