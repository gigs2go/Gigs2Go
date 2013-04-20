/**
 * 
 */
package com.gigs2go.model.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * @author tim
 * 
 */
@Embeddable
public class Email implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @org.hibernate.validator.constraints.Email( message = "{email.invalid}" )
    private String value = "";

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
