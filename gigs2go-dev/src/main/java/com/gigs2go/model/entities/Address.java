/**
 * 
 */
package com.gigs2go.model.entities;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

import org.apache.log4j.Logger;

/**
 * @author tim
 * 
 */
@Embeddable
public class Address {
    @Transient
    private Logger log = Logger.getLogger( Address.class );

    private String town;

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
