/**
 * 
 */
package com.gigs2go.mvc.formatters;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.gigs2go.model.entities.Email;

/**
 * @author tim
 * 
 */
public class EmailFormatter implements Formatter<Email> {

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.format.Printer#print(java.lang.Object,
     * java.util.Locale)
     */
    public String print ( Email arg0, Locale arg1 ) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.format.Parser#parse(java.lang.String,
     * java.util.Locale)
     */
    public Email parse ( String arg0, Locale arg1 ) throws ParseException {
        // TODO Auto-generated method stub
        return null;
    }

}
