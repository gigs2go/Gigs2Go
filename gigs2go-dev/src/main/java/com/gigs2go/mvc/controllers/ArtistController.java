/**
 * 
 */
package com.gigs2go.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.gigs2go.model.entities.Artist;
import com.gigs2go.model.services.ArtistService;
import com.gigs2go.mvc.validators.ArtistValidator;

/**
 * @author tim
 * 
 */
@Controller
// @RequestMapping( "/artists" )
public class ArtistController {
    private Logger log = LoggerFactory.getLogger( ArtistController.class );

    @Autowired
    private ArtistService service;

    @Autowired
    private ArtistValidator artistValidator;

    @InitBinder
    protected void initBinder ( WebDataBinder binder ) {
        binder.setValidator( artistValidator );
        binder.setDisallowedFields( "id" );
    }

    @RequestMapping( value = "/artists/add", method = RequestMethod.GET )
    public String add ( Model model ) {

        model.addAttribute( new Artist() );
        return "artists/addOrUpdate";

    }

    @RequestMapping( value = "/artists/add", method = RequestMethod.POST )
    public String create ( @Valid Artist artist, BindingResult result, Model model, SessionStatus status ) {

        if ( result.hasErrors() ) {
            return "artists/addOrUpdate";
        }
        service.save( artist );
        status.setComplete();

        List<Artist> artists = service.getArtists();

        model.addAttribute( "artists", artists );
        return "redirect:/artists";

    }

    @RequestMapping( value = "/artists/{artistId}/update", method = RequestMethod.GET )
    public String update ( @PathVariable( "artistId" ) Long artistId, Model model ) {

        Artist artist = service.getArtistById( artistId );
        log.debug( "Prepared update for artist " + artist );
        model.addAttribute( artist );
        return "/artists/addOrUpdate";

    }

    @RequestMapping( value = "/artists/{artistId}/update", method = RequestMethod.PUT )
    public String update ( @PathVariable( "artistId" ) Long artistId, @Valid Artist artist, BindingResult result, Model model, SessionStatus status ) {

        if ( result.hasErrors() ) {
            return "/artists/addOrUpdate";
        }
        log.debug( "Updating " + artist + "with Id " + artistId );
        artist.setId( artistId );
        service.save( artist );
        status.setComplete();

        List<Artist> artists = service.getArtists();

        model.addAttribute( "artists", artists );
        return "redirect:/artists";

    }

    @RequestMapping( value = "/artists", method = RequestMethod.GET )
    public String list ( Model model ) {
        List<Artist> artists = service.getArtists();

        log.debug( "Got " + artists.size() + " artists" );
        model.addAttribute( "artists", artists );
        return "artists/list";

    }

}
