/**
 * 
 */
package com.gigs2go.mvc.security;

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
public class LoginController {
    private Logger log = LoggerFactory.getLogger( LoginController.class );

    @Autowired
    private UserService service;

    @Autowired
    private UserValidator userValidator;

    @InitBinder
    protected void initBinder ( WebDataBinder binder ) {
        binder.setValidator( userValidator );
    }

    @RequestMapping( value = "/login", method = RequestMethod.GET )
    public String loginSetup ( Model model ) {

        log.debug( "Creating new User" );
        User user = new User();
        user.setEnabled( false );

        model.addAttribute( user );

        return "login/login";

    }

    @RequestMapping( value = "/login/failure", method = RequestMethod.GET )
    public String loginFailure ( Model model ) {

        log.debug( "Creating new User" );
        User user = new User();
        user.setEnabled( false );

        model.addAttribute( user );
        model.addAttribute( "fail", true );
        return "login/login";

    }

    @RequestMapping( value = "/register/new", method = RequestMethod.POST )
    public String newUser ( @Valid User user, BindingResult result, Model model ) {

        log.debug( "Result is {}", result );
        log.debug( "User is {}/{} - {}", user.getUsername(), user.getPassword(), user.getEnabled() );

        return "login/register";

    }

    @RequestMapping( value = "/register/add", method = RequestMethod.POST )
    public String addUser ( @Valid User user, BindingResult result, Model model, SessionStatus status ) {

        if ( result.hasErrors() ) {
            log.debug( "Errors" );
            return "login/register";
        }
        user.setEnabled( true );
        service.save( user );
        status.setComplete();

        return "redirect:/";

    }
}
