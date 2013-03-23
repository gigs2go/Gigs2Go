/**
 * 
 */
package com.gigs2go.model.entities;

import javax.persistence.Embeddable;

/**
 * @author tim
 * 
 */
@Embeddable
public class Email {
    private String value;

    public Email() {
    }

    public Email( String value ) {
        this.value = value;
    }

    /**
     * @return the email
     */
    public String getValue () {
        return this.value;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setValue ( String value ) {
        this.value = value;
    }

}
