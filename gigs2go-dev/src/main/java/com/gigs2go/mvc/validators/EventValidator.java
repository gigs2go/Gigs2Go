/**
 * 
 */
package com.gigs2go.mvc.validators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.gigs2go.model.entities.Event;

/**
 * @author tim
 * 
 */
@Component
public class EventValidator implements Validator {
    private Logger log = LoggerFactory.getLogger( EventValidator.class );

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
        ValidationUtils.rejectIfEmptyOrWhitespace( errors, "date", "field.required" );
        // ValidationUtils.rejectIfEmptyOrWhitespace( errors, "email.value",
        // "field.required" );
        Event event = (Event)target;
        log.debug( "Event date is " + event.getDate() );
        // if ( repo.findByName( artist.getName() ).size() > 0 ) {
        // errors.rejectValue( "name", "artist.name.exists" );
        // }
        // try {
        // errors.pushNestedPath( "email" );
        // ValidationUtils.invokeValidator( this.emailValidator,
        // artist.getEmail(), errors );
        // } finally {
        // errors.popNestedPath();
        // }
    }

}
