/**
 * 
 */
package com.gigs2go.mvc.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author tim
 * 
 */
@RunWith( SpringJUnit4ClassRunner.class )
public class ArtistControllerTest extends AbstractControllerTest {
    private Logger log = Logger.getLogger( ArtistControllerTest.class );

    @Test
    public void getArtist () throws Exception {
        this.mockMvc.perform( get( "/artists/1" ).accept( MediaType.TEXT_XML ) ).andExpect( status().isOk() );
    }
}