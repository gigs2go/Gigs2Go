package com.gigs2go.model.entities.security;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table( name = "users" )
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Transient
    private Logger log = LoggerFactory.getLogger( User.class );

    @Id
    @Column( updatable = false, nullable = false, length = 50 )
    private String username = "";

    @Column( updatable = false, nullable = false, length = 50 )
    @NotNull
    private String password = "";

    @Enumerated( EnumType.STRING )
    private UserType userType = UserType.USER;

    @NotNull
    private Boolean enabled = Boolean.FALSE;

    @OneToMany( mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    private Set<Authority> authorities = new HashSet<Authority>();

    @Transient
    private String checkPassword = "";

    /**
     * @return the checkPassword
     */
    public String getCheckPassword () {
        return this.checkPassword;
    }

    /**
     * @param checkPassword
     *            the checkPassword to set
     */
    public void setCheckPassword ( String checkPassword ) {
        this.checkPassword = checkPassword;
    }

    public String getUsername () {
        return username;
    }

    public void setUsername ( String username ) {
        this.username = username;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword ( String password ) {
        this.password = password;
    }

    /**
     * @return the userType
     */
    public UserType getUserType () {
        return this.userType;
    }

    /**
     * @param userType
     *            the userType to set
     */
    public void setUserType ( UserType userType ) {
        this.userType = userType;
    }

    public Boolean getEnabled () {
        return enabled;
    }

    public void setEnabled ( Boolean enabled ) {
        this.enabled = enabled;
    }

    public Set<Authority> getAuthorities () {
        return authorities;
    }

    public void setAuthorities ( Set<Authority> authorities ) {
        this.authorities = authorities;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString () {
        return "User [username=" + this.username + ", password=" + this.password + ", userType=" + this.userType + ", enabled=" + this.enabled + ", authorities=" + this.authorities + ", checkPassword=" + this.checkPassword + "]";
    }

}
