/**
 * 
 */
package com.gigs2go.mvc.validators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.gigs2go.model.entities.Artist;
import com.gigs2go.model.repos.ArtistRepository;

/**
 * @author tim
 * 
 */
@Component
public class ArtistValidator implements Validator {
    private Logger log = LoggerFactory.getLogger( ArtistValidator.class );

    @Autowired
    private EmailValidator emailValidator;

    @Autowired
    private ArtistRepository repo;

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.validation.Validator#supports(java.lang.Class)
     */
    public boolean supports ( Class<?> clazz ) {
        return Artist.class.equals( clazz );
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.validation.Validator#validate(java.lang.Object,
     * org.springframework.validation.Errors)
     */
    public void validate ( Object target, Errors errors ) {
        ValidationUtils.rejectIfEmptyOrWhitespace( errors, "name", "field.required" );
        ValidationUtils.rejectIfEmptyOrWhitespace( errors, "email.value", "field.required" );
        Artist artist = (Artist)target;
        log.debug( "Checking for Artist with name " + artist.getName() );
        if ( repo.findByName( artist.getName() ).size() > 0 ) {
            errors.rejectValue( "name", "artist.name.exists" );
        }
        try {
            errors.pushNestedPath( "email" );
            ValidationUtils.invokeValidator( this.emailValidator, artist.getEmail(), errors );
        } finally {
            errors.popNestedPath();
        }
    }

}
