package com.gigs2go.model.entities;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.log4j.Logger;

@Entity
@Table( name = "venues" )
public class Venue {
    @Transient
    private Logger log = Logger.getLogger( Venue.class );

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;

    private String name;

    @Embedded
    @AttributeOverrides( { @AttributeOverride( name = "value", column = @Column( name = "email" ) ) } )
    private Email email;

    @Embedded
    private Address address;

    @OneToMany
    private Set<Event> events;

    /**
     * @return the events
     */
    public Set<Event> getEvents () {
        return this.events;
    }

    /**
     * @param events
     *            the events to set
     */
    public void setEvents ( Set<Event> events ) {
        this.events = events;
    }

    /**
     * @return the address
     */
    public Address getAddress () {
        return this.address;
    }

    /**
     * @param address
     *            the address to set
     */
    public void setAddress ( Address address ) {
        this.address = address;
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
     * @return the name
     */
    public String getName () {
        return this.name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName ( String name ) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public Email getEmail () {
        return this.email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail ( Email email ) {
        this.email = email;
    }

}
