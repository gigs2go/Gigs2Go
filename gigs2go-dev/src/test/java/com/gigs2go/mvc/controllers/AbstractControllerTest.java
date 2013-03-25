/**
 * 
 */
package com.gigs2go.mvc.controllers;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author tim
 * 
 */
@WebAppConfiguration
@ContextConfiguration( { "classpath*:config/repo.xml", "classpath*:config/mvc.xml" } )
public class AbstractControllerTest {
    private Logger log = Logger.getLogger( AbstractControllerTest.class );

    @Autowired
    protected WebApplicationContext wac;
    protected MockMvc mockMvc;

    @Before
    public void setup () {
        this.mockMvc = webAppContextSetup( this.wac ).build();
    }

}