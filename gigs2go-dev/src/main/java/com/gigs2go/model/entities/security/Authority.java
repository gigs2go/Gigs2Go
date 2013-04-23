package com.gigs2go.model.entities.security;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gigs2go.model.entities.Artist;

@Entity
@Table( name = "authorities" )
// @org.hibernate.annotations.Table(appliesTo="authorities", indexes = {
// @Index(name="authorities_idx_1", columnNames={"username", "authority"})})
public class Authority implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Transient
    private Logger log = LoggerFactory.getLogger( Artist.class );

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;

    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "username" )
    private User user;

    @Column( updatable = false, nullable = false, length = 50 )
    @NotNull
    private String authority;

    public User getUser () {
        return user;
    }

    public void setUser ( User user ) {
        this.user = user;
    }

    public String getAuthority () {
        return authority;
    }

    public void setAuthority ( String authority ) {
        this.authority = authority;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode () {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.authority == null) ? 0 : this.authority.hashCode());
        result = prime * result + ((this.user == null) ? 0 : this.user.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals ( Object obj ) {
        if ( this == obj )
            return true;
        if ( obj == null )
            return false;
        if ( getClass() != obj.getClass() )
            return false;
        Authority other = (Authority)obj;
        if ( this.authority == null ) {
            if ( other.authority != null )
                return false;
        } else if ( !this.authority.equals( other.authority ) )
            return false;
        if ( this.user == null ) {
            if ( other.user != null )
                return false;
        } else if ( !this.user.equals( other.user ) )
            return false;
        return true;
    }

}
