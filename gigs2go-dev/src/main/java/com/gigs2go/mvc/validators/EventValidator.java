/**
 * 
 */
package com.gigs2go.mvc.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.gigs2go.model.entities.Event;

/**
 * @author tim
 * 
 */
public class EventValidator implements Validator {

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.validation.Validator#supports(java.lang.Class)
     */
    public boolean supports ( Class<?> clazz ) {
        return Event.class.equals( clazz );
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.validation.Validator#validate(java.lang.Object,
     * org.springframework.validation.Errors)
     */
    public void validate ( Object target, Errors errors ) {
        // ValidationUtils.rejectIfEmptyOrWhitespace( errors, "name",
        // "field.required" );
        // ValidationUtils.rejectIfEmptyOrWhitespace( errors, "email.email",
        // "field.required" );
        // Artist artist = (Artist)target;
    }

}
