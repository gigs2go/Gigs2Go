/**
 * 
 */
package com.gigs2go.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * @author tim
 * 
 */
public class Utils {

    private static Logger log = Logger.getLogger( Utils.class );

    public static Date getDate ( String date ) {
        Date result = new Date();
        try {
            result = new SimpleDateFormat( "yyyy-MM-dd" ).parse( date );
        } catch ( ParseException e ) {
            log.error( "Invalid Date? : " + date, e );
        }
        return result;
    }

}
