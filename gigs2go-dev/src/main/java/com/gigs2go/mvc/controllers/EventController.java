/**
 * 
 */
package com.gigs2go.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.gigs2go.model.entities.Event;
import com.gigs2go.model.services.ArtistService;
import com.gigs2go.model.services.EventService;
import com.gigs2go.model.services.VenueService;
import com.gigs2go.mvc.validators.EventValidator;

/**
 * @author tim
 * 
 */
@Controller
// @RequestMapping( "/events" )
public class EventController {
    private Logger log = Logger.getLogger( EventController.class );

    @Autowired
    private EventService service;

    @Autowired
    private ArtistService artistService;

    @Autowired
    private VenueService venueService;

    @Autowired
    private EventValidator eventValidator;

    @InitBinder
    protected void initBinder ( WebDataBinder binder ) {
        binder.setValidator( eventValidator );
        binder.setDisallowedFields( "id" );
    }

    @RequestMapping( value = "/events/add", method = RequestMethod.GET )
    public String add ( Model model ) {

        log.debug( "Events add via GET" );
        Event event = new Event();
        event.setDate( LocalDate.now() );
        model.addAttribute( event );
        model.addAttribute( "artists", artistService.getArtists() );
        model.addAttribute( "venues", venueService.getVenues() );
        return "/events/addOrUpdate";

    }

    @RequestMapping( value = "/events/add", method = RequestMethod.POST )
    public String add ( @Valid Event event, Model model, BindingResult result, SessionStatus status ) {

        log.debug( "Events add via POST" );
        // log.debug( "event artist is " + event.getArtist().getId() +
        // ", event venue is " + event.getVenue().getId() );
        // new EventValidator().validate( event, result );
        if ( result.hasErrors() ) {
            log.debug( "Errors - returning add" );
            // model.addAttribute( "artists", artistService.getArtists() );
            // model.addAttribute( "venues", venueService.getVenues() );
            return "/events/addOrUpdate";
        }
        service.save( event );
        status.setComplete();

        List<Event> events = service.getEvents();

        log.debug( "Got " + events.size() + " events" );
        model.addAttribute( "events", events );
        log.debug( "Returning list" );
        return "redirect:/events";

    }

    @RequestMapping( value = "/events/{eventId}/update", method = RequestMethod.GET )
    public String update ( @PathVariable( "eventId" ) Long eventId, Model model ) {

        Event event = service.getEventById( eventId );
        log.debug( "Prepared update for event " + event );
        model.addAttribute( event );
        return "/events/addOrUpdate";

    }

    @RequestMapping( value = "/events/{eventId}/update", method = RequestMethod.PUT )
    public String update ( @PathVariable( "eventId" ) Long eventId, @Valid Event event, BindingResult result, Model model, SessionStatus status ) {

        if ( result.hasErrors() ) {
            return "/events/addOrUpdate";
        }
        log.debug( "Updating " + event + "with Id " + eventId );
        event.setId( eventId );
        service.save( event );
        status.setComplete();

        List<Event> events = service.getEvents();

        model.addAttribute( "events", events );
        return "redirect:/events";

    }

    @RequestMapping( value = "/events", method = RequestMethod.GET )
    public String list ( ModelMap model ) {
        List<Event> events = service.getEvents();

        log.debug( "Got " + events.size() + " events" );
        model.addAttribute( "events", events );
        return "/events/list";

    }

}
