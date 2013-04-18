package com.gigs2go.mvc.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

/**
 * @author tim
 * 
 */
@Service
public class SecurityLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private Logger log = LoggerFactory.getLogger( SecurityLoginSuccessHandler.class );

    public SecurityLoginSuccessHandler() {
        super();
    }

    public void onAuthenticationSuccess ( HttpServletRequest request, HttpServletResponse response, Authentication auth ) throws IOException, ServletException {
        log.debug( "Successfully logged in with User :'{}'", auth.getName() );

        if ( "XMLHttpRequest".equals( request.getHeader( "X-Requested-With" ) ) ) {
            response.getWriter().print( "{success:true, targetUrl : \'" + this.getTargetUrlParameter() + "\'}" );
            response.getWriter().flush();
        } else {
            super.onAuthenticationSuccess( request, response, auth );
        }
    }
}
