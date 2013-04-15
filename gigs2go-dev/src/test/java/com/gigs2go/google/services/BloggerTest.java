/**
 * 
 */
package com.gigs2go.google.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.api.services.blogger.model.Blog;
import com.google.api.services.blogger.model.Post;

//import org.slf4j.Logger; import org.slf4j.LoggerFactory;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( { "classpath*:config/blogger.xml" } )
public class BloggerTest {

    Logger log = LoggerFactory.getLogger( BloggerTest.class );

    @Autowired
    private BloggerService bloggerService;

    @Before
    public void setup () throws GeneralSecurityException, IOException {

        // this.bloggerService = new BloggerService();
        bloggerService.setupService( "706237246612@developer.gserviceaccount.com", "510cb58e8407c8a322e197be022a5217e1ed0a27-privatekey.p12", "Gigs2Go" );
        assertNotNull( bloggerService );
    }

    @Test
    public void testGetPost () {
        log.debug( "Test get post" );
        // PostList list = null;
        Blog blog = null;
        java.util.List<Post> posts = null;
        try {
            bloggerService.executeGetBlogByUrl( "http://gigs2godev.blogspot.co.uk/" );
            blog = bloggerService.getBlog();
            assertNotNull( blog );
            log.debug( "Got Blog " + blog.toPrettyString() );
            bloggerService.executeGetPosts();
            posts = bloggerService.getPosts();
            assertEquals( 1, posts.size() );
            Post post = posts.get( 0 );
            log.debug( "Got Post " + post.toPrettyString() );

        } catch ( IOException e ) {
            fail( e.getMessage() );
        }
    }

}
