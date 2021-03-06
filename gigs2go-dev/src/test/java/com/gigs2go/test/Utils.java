/**
 * 
 */
package com.gigs2go.test;

import org.slf4j.Logger; import org.slf4j.LoggerFactory;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * @author tim
 * 
 */
public class Utils {

    private static Logger log = LoggerFactory.getLogger( Utils.class );

    public static LocalDate getDate ( String date ) {
        LocalDate result = new LocalDate();
        DateTimeFormatter formatter = DateTimeFormat.forPattern( "yyyy-MM-dd" );
        result = LocalDate.parse( date, formatter );
        return result;
    }

}
