/**
 * 
 */
package com.gigs2go.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.gigs2go.model.entities.Venue;
import com.gigs2go.model.services.VenueService;
import com.gigs2go.mvc.validators.VenueValidator;

/**
 * @author tim
 * 
 */
@Controller
// @RequestMapping( "/venues" )
public class VenueController {
    private Logger log = Logger.getLogger( VenueController.class );

    @Autowired
    private VenueService service;

    @Autowired
    private VenueValidator venueValidator;

    @InitBinder
    protected void initBinder ( WebDataBinder binder ) {
        binder.setValidator( venueValidator );
        binder.setDisallowedFields( "id" );
    }

    @RequestMapping( value = "/venues/add", method = RequestMethod.GET )
    public String add ( Model model ) {

        model.addAttribute( new Venue() );
        return "venues/addOrUpdate";

    }

    @RequestMapping( value = "/venues/add", method = RequestMethod.POST )
    public String create ( @Valid Venue venue, BindingResult result, SessionStatus status ) {

        if ( result.hasErrors() ) {
            return "venues/addOrUpdate";
        }
        service.save( venue );
        status.setComplete();

        List<Venue> venues = service.getVenues();

        result.getModel().put( "venues", venues );
        return "redirect:/venues";

    }

    @RequestMapping( value = "/venues/{venueId}/update", method = RequestMethod.GET )
    public String update ( @PathVariable( "venueId" ) Long venueId, Model model ) {

        Venue venue = service.getVenueById( venueId );
        log.debug( "Prepared update for venue " + venue );
        model.addAttribute( venue );
        return "/venues/addOrUpdate";

    }

    @RequestMapping( value = "/venues/{venueId}/update", method = RequestMethod.PUT )
    public String update ( @PathVariable( "venueId" ) Long venueId, @Valid Venue venue, BindingResult result, SessionStatus status ) {

        if ( result.hasErrors() ) {
            return "/venues/addOrUpdate";
        }
        log.debug( "Updating " + venue + "with Id " + venueId );
        venue.setId( venueId );
        service.save( venue );
        status.setComplete();

        List<Venue> venues = service.getVenues();

        result.getModel().put( "venues", venues );
        return "redirect:/venues";

    }

    @RequestMapping( value = "/venues", method = RequestMethod.GET )
    public String list ( Model model ) {
        List<Venue> venues = service.getVenues();

        log.debug( "Got " + venues.size() + " venues" );
        model.addAttribute( "venues", venues );
        return "venues/list";

    }

}
