/**
 * 
 */
package com.gigs2go.mvc.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.gigs2go.model.entities.Venue;

/**
 * @author tim
 * 
 */
@Component
public class VenueValidator implements Validator {

    @Autowired
    private EmailValidator emailValidator;

    @Autowired
    private AddressValidator addressValidator;

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.validation.Validator#supports(java.lang.Class)
     */
    public boolean supports ( Class<?> clazz ) {
        return Venue.class.equals( clazz );
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.validation.Validator#validate(java.lang.Object,
     * org.springframework.validation.Errors)
     */
    public void validate ( Object target, Errors errors ) {
        ValidationUtils.rejectIfEmptyOrWhitespace( errors, "name", "field.required" );
        Venue venue = (Venue)target;
        try {
            errors.pushNestedPath( "email" );
            ValidationUtils.invokeValidator( this.emailValidator, venue.getEmail(), errors );
        } finally {
            errors.popNestedPath();
        }
        try {
            errors.pushNestedPath( "address" );
            ValidationUtils.invokeValidator( this.addressValidator, venue.getAddress(), errors );
        } finally {
            errors.popNestedPath();
        }
    }

}
