/**
 * 
 */
package com.gigs2go.mvc.controllers;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gigs2go.model.entities.Event;
import com.gigs2go.model.services.ArtistService;
import com.gigs2go.model.services.EventService;
import com.gigs2go.model.services.VenueService;

/**
 * @author tim
 * 
 */
@Controller
@RequestMapping( "/events" )
public class EventController {
    private Logger log = Logger.getLogger( EventController.class );

    @Autowired
    private EventService service;

    @Autowired
    private ArtistService artistService;

    @Autowired
    private VenueService venueService;

    @RequestMapping( value = "/list", method = RequestMethod.GET )
    public String list ( ModelMap model ) {
        List<Event> events = service.getEvents();

        log.debug( "Got " + events.size() + " events" );
        model.addAttribute( "events", events );
        return "/events/list";

    }

    @RequestMapping( value = "/add", method = RequestMethod.GET )
    public String add ( ModelMap model ) {

        log.debug( "Events add via GET" );
        Event event = new Event();
        event.setDayt( new Date() );
        model.addAttribute( "event", event );
        model.addAttribute( "artists", artistService.getArtists() );
        model.addAttribute( "venues", venueService.getVenues() );
        return "events/add";

    }

    @RequestMapping( value = "/add", method = RequestMethod.POST )
    // @Valid JavaBean bean, BindingResult result
    public String add ( @ModelAttribute( "event" ) Event event, ModelMap model, BindingResult result ) {

        log.debug( "Events add via POST" );
        // log.debug( "event artist is " + event.getArtist().getId() +
        // ", event venue is " + event.getVenue().getId() );
        // new EventValidator().validate( event, result );
        if ( result.hasErrors() ) {
            log.debug( "Errors - returning add" );
            // model.addAttribute( "artists", artistService.getArtists() );
            // model.addAttribute( "venues", venueService.getVenues() );
            return "events/add";
        }
        service.save( event );
        List<Event> events = service.getEvents();

        log.debug( "Got " + events.size() + " events" );
        result.getModel().put( "events", events );
        log.debug( "Returning list" );
        return "redirect:list";

    }

}
