/**
 * 
 */
package com.gigs2go.mvc.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserValidator userValidator;

    @InitBinder
    protected void initBinder ( WebDataBinder binder ) {
        binder.setValidator( userValidator );
    }

    @RequestMapping( value = "/login/login", method = RequestMethod.GET )
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

    @RequestMapping( value = "/login/key/{key}", method = RequestMethod.GET )
    public String loginConfirm ( @PathVariable String key, @ModelAttribute( "user" ) User user, BindingResult result, HttpServletRequest request, HttpServletResponse response ) {

        log.debug( "Loading existing User" );
        user = service.getUserByKey( key );
        user.setEnabled( true );
        service.save( user );

        // Insert authentication into session
        log.debug( "Authenticating User" );
        authenticateUserAndSetSession( user, request );

        return "redirect:/";

    }

    private void authenticateUserAndSetSession ( User user, HttpServletRequest request ) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken( user.getUsername(), user.getPassword() );

        // generate session if one doesn't exist
        request.getSession();

        token.setDetails( new WebAuthenticationDetails( request ) );
        Authentication authenticatedUser = authenticationManager.authenticate( token );

        SecurityContextHolder.getContext().setAuthentication( authenticatedUser );
    }
}
