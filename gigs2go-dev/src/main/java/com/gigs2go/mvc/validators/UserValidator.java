package com.gigs2go.mvc.validators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.gigs2go.model.entities.security.User;
import com.gigs2go.model.repos.security.UserRepository;

/**
 * @author tim
 * 
 */
@Component
public class UserValidator implements Validator {
    private Logger log = LoggerFactory.getLogger( UserValidator.class );

    @Autowired
    private UserRepository repo;

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.validation.Validator#supports(java.lang.Class)
     */
    public boolean supports ( Class<?> clazz ) {
        return User.class.equals( clazz );
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.validation.Validator#validate(java.lang.Object,
     * org.springframework.validation.Errors)
     */
    public void validate ( Object target, Errors errors ) {
        ValidationUtils.rejectIfEmptyOrWhitespace( errors, "username", "field.required" );
        ValidationUtils.rejectIfEmptyOrWhitespace( errors, "password", "field.required" );
        // ValidationUtils.rejectIfEmptyOrWhitespace( errors, "checkPassword",
        // "field.required" );
        User user = (User)target;
        log.debug( "Checking for User with username " + user.getUsername() );
        if ( repo.findByUsername( user.getUsername() ) != null ) {
            errors.rejectValue( "username", "user.name.exists" );
        }
    }

}
