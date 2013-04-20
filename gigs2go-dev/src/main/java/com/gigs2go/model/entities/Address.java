/**
 * 
 */
package com.gigs2go.model.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tim
 * 
 */
@Embeddable
public class Address implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Transient
    private Logger log = LoggerFactory.getLogger( Address.class );

    private String town = "";

    /**
     * @return the town
     */
    public String getTown () {
        return this.town;
    }

    /**
     * @param town
     *            the town to set
     */
    public void setTown ( String town ) {
        this.town = town;
    }
}
