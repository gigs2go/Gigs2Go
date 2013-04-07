package com.gigs2go.model.entities;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.apache.log4j.Logger;

@Entity
@Table( name = "venues" )
public class Venue extends BaseEntity {
    @Transient
    private Logger log = Logger.getLogger( Venue.class );

    private String name;

    @Embedded
    @AttributeOverrides( { @AttributeOverride( name = "value", column = @Column( name = "email" ) ) } )
    @NotNull
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
