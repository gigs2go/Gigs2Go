/**
 * 
 */
package com.gigs2go.mvc.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gigs2go.model.entities.Artist;
import com.gigs2go.model.services.ArtistService;

/**
 * @author tim
 * 
 */
@Controller
@RequestMapping( "/artists" )
public class ArtistController {
    private Logger log = Logger.getLogger( ArtistController.class );

    @Autowired
    ArtistService service;

    @RequestMapping( value = "/add", method = RequestMethod.GET )
    public String add ( ModelMap model ) {

        model.addAttribute( "artist", new Artist() );
        return "artists/add";

    }

    @RequestMapping( value = "/add", method = RequestMethod.POST )
    public String create ( ModelMap model ) {

        Artist artist = (Artist)model.get( "artist" );
        service.save( artist );
        return "artists/list";

    }

}
