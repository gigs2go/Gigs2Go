/**
 * 
 */
package com.gigs2go.google.services;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.services.blogger.Blogger;
import com.google.api.services.blogger.Blogger.Blogs.GetByUrl;
import com.google.api.services.blogger.Blogger.Posts.List;
import com.google.api.services.blogger.BloggerScopes;
import com.google.api.services.blogger.model.Blog;
import com.google.api.services.blogger.model.Post;
import com.google.api.services.blogger.model.PostList;

/**
 * @author tim
 * 
 */
@Component
public class BloggerService {
    Logger log = LoggerFactory.getLogger( BloggerService.class );

    @Autowired
    private ResourceLoader resourceLoader;

    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    private static final JsonFactory JSON_FACTORY = new JacksonFactory();

    private String p12KeyFileName = "";
    private Blogger blogger = null;
    private Blog blog;
    private java.util.List<Post> posts;

    String oAuthToken = "";

    /**
     * 
     */
    public BloggerService() {
    }

    public void setupService ( String serviceAccountId, String p12KeyFileName, String applicationName ) throws GeneralSecurityException, IOException {
        HttpTransport httpTransport = new NetHttpTransport();
        JsonFactory jsonFactory = new JacksonFactory();

        this.p12KeyFileName = p12KeyFileName;

        GoogleCredential credential = null;
        log.debug( "ResourceLoader is " + resourceLoader );
        File p12File = resourceLoader.getResource( this.p12KeyFileName ).getFile();
        credential = new GoogleCredential.Builder().setTransport( HTTP_TRANSPORT ).setJsonFactory( JSON_FACTORY ).setServiceAccountId( serviceAccountId ).setServiceAccountScopes( BloggerScopes.BLOGGER ).setServiceAccountPrivateKeyFromP12File( p12File ).build();
        credential.refreshToken();
        this.oAuthToken = credential.getAccessToken();

        this.blogger = new com.google.api.services.blogger.Blogger.Builder( httpTransport, jsonFactory, credential ).setApplicationName( applicationName ).setHttpRequestInitializer( credential ).build();
    }

    public void executeGetBlogByUrl ( String url ) throws IOException {
        GetByUrl request = blogger.blogs().getByUrl( url );
        request.setOauthToken( this.oAuthToken );
        this.blog = request.execute();
    }

    public void executeGetPosts () throws IOException {
        List request = blogger.posts().list( blog.getId() );
        request.setOauthToken( this.oAuthToken );
        PostList postList = request.execute();
        this.posts = postList.getItems();
    }

    /**
     * @return the blog
     */
    public Blog getBlog () {
        return this.blog;
    }

    /**
     * @return the posts
     */
    public java.util.List<Post> getPosts () {
        return this.posts;
    }

}
