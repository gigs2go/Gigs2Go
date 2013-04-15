/**
 * 
 */
package com.gigs2go.mvc.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.slf4j.Logger; import org.slf4j.LoggerFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author tim
 * 
 */
@RunWith( SpringJUnit4ClassRunner.class )
public class VenueControllerTest extends AbstractControllerTest {
    private Logger log = LoggerFactory.getLogger( VenueControllerTest.class );

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup () {
        this.mockMvc = webAppContextSetup( this.wac ).build();
    }

    @Test
    public void listVenues () throws Exception {
        this.mockMvc.perform( get( "/venues" ).accept( MediaType.ALL ) ).andExpect( status().isOk() );

    }

    @Test
    public void addVenue () throws Exception {
        this.mockMvc.perform( get( "/venues/add" ).accept( MediaType.ALL ) ).andExpect( status().isOk() );

    }
}