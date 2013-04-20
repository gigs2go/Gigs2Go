package com.gigs2go.model.entities;

import java.util.HashSet;
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

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table( name = "artists" )
public class Artist extends BaseEntity {
    @Transient
    private Logger log = LoggerFactory.getLogger( Artist.class );

    @NotNull
    @NotEmpty
    @NotBlank
    private String name = "";

    @Embedded
    @AttributeOverrides( { @AttributeOverride( name = "value", column = @Column( name = "email" ) ) } )
    @NotNull
    private Email email = new Email();

    @OneToMany( mappedBy = "artist" )
    private Set<Event> events = new HashSet<Event>();

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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString () {
        return "Artist [super=" + super.toString() + ", name=" + this.name + ", email=" + this.email + "]";
    }

}
