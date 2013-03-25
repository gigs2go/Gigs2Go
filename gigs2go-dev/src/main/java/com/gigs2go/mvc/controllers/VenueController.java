/**
 * 
 */
package com.gigs2go.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gigs2go.model.entities.Venue;
import com.gigs2go.model.services.VenueService;

/**
 * @author tim
 * 
 */
@Controller
@RequestMapping( "/venues" )
public class VenueController {
    private Logger log = Logger.getLogger( VenueController.class );

    @Autowired
    private VenueService service;

    @RequestMapping( value = "/list", method = RequestMethod.GET )
    public String list ( ModelMap model ) {
        List<Venue> venues = service.getVenues();

        log.debug( "Got " + venues.size() + " venues" );
        model.addAttribute( "venues", venues );
        return "venues/list";

    }

    @RequestMapping( value = "/add", method = RequestMethod.GET )
    public String add ( ModelMap model ) {

        model.addAttribute( "venue", new Venue() );
        return "venues/add";

    }

    @RequestMapping( value = "/add", method = RequestMethod.POST )
    public String create ( @Valid Venue venue, BindingResult result ) {

        if ( result.hasErrors() ) {
            return "venues/add";
        }
        service.save( venue );
        List<Venue> venues = service.getVenues();

        log.debug( "Got " + venues.size() + " venues" );
        result.getModel().put( "venues", venues );
        return "redirect:list";

    }

}
