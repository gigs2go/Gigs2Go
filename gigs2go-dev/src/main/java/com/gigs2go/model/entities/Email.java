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
    @org.hibernate.validator.constraints.Email( message = "{email.invalid}" )
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
     * @param value
     *            the email to set
     */
    public void setValue ( String value ) {
        this.value = value;
    }

}
