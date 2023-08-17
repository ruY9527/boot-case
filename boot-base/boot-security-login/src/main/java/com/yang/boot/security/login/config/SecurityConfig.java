package com.yang.boot.security.login.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

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

@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${spring.security.remember-me.key}")
    private String rememberKey;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();

        http.authorizeRequests()
                .antMatchers("/admin/api/**")
                .hasRole("ADMIN")
                .antMatchers("/user/api/**")
                .hasRole("USER")
                .antMatchers("/app/api/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .rememberMe()
                .userDetailsService(userDetailsService)
                // 1. 散列加密方案
                .key(rememberKey)
                // 2. 持久化令牌方案
                //.tokenRepository(tokenRepository)
                // 7天有效期
                //.tokenValiditySeconds(60 * 60 * 24 * 7)
                .and()
                .logout()
                .logoutUrl("/myLogout")
                // 注销成功，重定向到该路径下
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .and()
                .csrf()
                .disable();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
