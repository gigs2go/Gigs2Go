/**
 * 
 */
package com.gigs2go.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
//import org.hibernate.annotations.Type;
//import org.joda.time.contrib.hibernate.PersistentDateTime;

/**
 * @author tim
 * 
 */
@Entity
@Table( name = "events" )
public class Event extends BaseEntity {
    @Transient
    private Logger log = LoggerFactory.getLogger( Event.class );

    @ManyToOne
    private Artist artist;

    @ManyToOne
    private Venue venue;

    // @Temporal( value = TemporalType.DATE )
    @DateTimeFormat( pattern = "yyyy/MM/dd (EEE, MMM dd)" )
    @NotNull
    // @Type( type = "org.joda.time.contrib.hibernate.PersistentDateTime" )
    @Type( type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate" )
    @Column( name = "dayt" )
    private LocalDate date;

    /**
     * @return the date
     */
    public LocalDate getDate () {
        return this.date;
    }

    /**
     * @param date
     *            the date to set
     */
    public void setDate ( LocalDate date ) {
        this.date = date;
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
