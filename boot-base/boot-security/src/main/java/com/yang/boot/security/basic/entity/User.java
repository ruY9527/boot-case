package com.yang.boot.security.basic.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 19-12-29
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/

@Data
public class User implements UserDetails {


    private Long id;

    private String username;

    private String password;

    private String roles;

    private boolean enable;

    private List<GrantedAuthority> authorities;

    @Override
    public boolean equals(Object obj) {
        return obj instanceof User ? this.username.equals(((User) obj).username) : false;
    }

    @Override
    public int hashCode() {
        return this.username.hashCode();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
