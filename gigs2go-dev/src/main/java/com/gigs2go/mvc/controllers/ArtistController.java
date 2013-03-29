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
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gigs2go.model.entities.Artist;
import com.gigs2go.model.services.ArtistService;
import com.gigs2go.mvc.validators.ArtistValidator;

/**
 * @author tim
 * 
 */
@Controller
@RequestMapping( "/artists" )
public class ArtistController {
    private Logger log = Logger.getLogger( ArtistController.class );

    @Autowired
    private ArtistService service;

    @InitBinder
    protected void initBinder ( WebDataBinder binder ) {
        binder.setValidator( new ArtistValidator() );
    }

    @RequestMapping( value = "/list", method = RequestMethod.GET )
    public String list ( ModelMap model ) {
        List<Artist> artists = service.getArtists();

        log.debug( "Got " + artists.size() + " artists" );
        model.addAttribute( "artists", artists );
        return "artists/list";

    }

    @RequestMapping( value = "/add", method = RequestMethod.GET )
    public String add ( ModelMap model ) {

        model.addAttribute( "artist", new Artist() );
        return "/artists/add";

    }

    @RequestMapping( value = "/add", method = RequestMethod.POST )
    public String create ( @Valid Artist artist, BindingResult result ) {

        if ( result.hasErrors() ) {
            return "/artists/add";
        }
        service.save( artist );
        List<Artist> artists = service.getArtists();

        log.debug( "Got " + artists.size() + " artists" );
        result.getModel().put( "artists", artists );
        return "redirect:/artists/list";

    }

}
