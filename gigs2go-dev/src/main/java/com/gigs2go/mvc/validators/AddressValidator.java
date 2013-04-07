/**
 * 
 */
package com.gigs2go.mvc.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.gigs2go.model.entities.Address;

/**
 * @author tim
 * 
 */
@Component
public class AddressValidator implements Validator {

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.validation.Validator#supports(java.lang.Class)
     */
    public boolean supports ( Class<?> clazz ) {
        return Address.class.equals( clazz );
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.validation.Validator#validate(java.lang.Object,
     * org.springframework.validation.Errors)
     */
    public void validate ( Object target, Errors errors ) {
        Address address = (Address)target;
        String town = address.getTown();
        // TODO - regexp
        if ( !town.equals( "Faversham" ) ) {
            errors.rejectValue( "town", "town.invalid" );
        }
    }

}
