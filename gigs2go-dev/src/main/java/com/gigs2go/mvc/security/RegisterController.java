/**
 * 
 */
package com.gigs2go.mvc.security;

import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.gigs2go.model.entities.security.User;
import com.gigs2go.model.services.UserService;
import com.gigs2go.mvc.validators.UserValidator;

/**
 * @author tim
 * 
 */
@Controller
public class RegisterController {
    private Logger log = LoggerFactory.getLogger( RegisterController.class );

    @Autowired
    private UserService service;

    @Autowired
    private UserValidator userValidator;

    @InitBinder
    protected void initBinder ( WebDataBinder binder ) {
        binder.setValidator( userValidator );
    }

    @RequestMapping( value = "/register/new", method = RequestMethod.POST )
    public String add ( Model model ) {

        User user = new User();
        Map<String, Object> modelMap = model.asMap();
        for ( String key : modelMap.keySet() ) {
            log.debug( "Key {}", key );
        }
        log.debug( "Should pre-set username/password to {}/{}", model.asMap().get( "username" ), model.asMap().get( "password" ) );

        model.addAttribute( user );
        return "login/register";

    }

    @RequestMapping( value = "/register/add", method = RequestMethod.POST )
    public String create ( @Valid User user, BindingResult result, Model model, SessionStatus status ) {

        if ( result.hasErrors() ) {
            log.debug( "Errors" );
            return "login/register";
        }
        service.save( user );
        status.setComplete();

        return "redirect:/";

    }

}
