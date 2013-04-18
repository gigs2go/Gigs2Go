/**
 * 
 */
package com.gigs2go.mvc.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Service;

/**
 * @author tim
 * 
 */
@Service
public class SecurityLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    private Logger log = LoggerFactory.getLogger( SecurityLoginFailureHandler.class );

    @Override
    public void onAuthenticationFailure ( HttpServletRequest request, HttpServletResponse response, AuthenticationException exception ) throws IOException, ServletException {
        log.debug( "Successfully logged in with User :'{}'", exception.getMessage() );

        if ( "XMLHttpRequest".equals( request.getHeader( "X-Requested-With" ) ) ) {
            response.getWriter().print( "{success:false, message: 'Username/Password are invalid'}" );
            response.getWriter().flush();
        } else {
            super.onAuthenticationFailure( request, response, exception );
        }
    }

}
