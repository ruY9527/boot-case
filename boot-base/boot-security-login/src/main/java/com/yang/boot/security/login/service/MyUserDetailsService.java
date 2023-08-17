package com.yang.boot.security.login.service;

import com.yang.boot.security.login.entity.User;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // 模拟从数据库中获取密码
        if(!"gavin".equalsIgnoreCase(s)){
           throw new UsernameNotFoundException(s);
        }
        // String [] roleArr = {"ADMIN","USER"};
        User user = new User();
        user.setUsername("gavin");
        user.setPassword("12345");
        user.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList("ADMIN,USER"));
        return user;
    }
}
