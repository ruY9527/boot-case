package com.yang.boot.security.basic.config;

import com.yang.boot.security.basic.config.filter.VerificationCodeFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: Mu_Yi
 * @Date: 2019/12/27 23:45
 * @Version 1.0
 * @qq: 1411091515
 */

@Slf4j
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.info("Using default configure(HttpSecurity).");
        // http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
        // http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/myLogin.html").permitAll().and().csrf().disable();
        http.authorizeRequests()
                .antMatchers("/capth/**","/captcha.jpg").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/myLogin.html").loginProcessingUrl("/login")
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=UTF-8");
                        PrintWriter printWriter = httpServletResponse.getWriter();
                        printWriter.write("{\"error_code\":\"0\",\"message\":\"欢迎登陆系统\"}");
                    }
                }).failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest httpServletRequest,
                                                        HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=UTF-8");
                        httpServletResponse.setStatus(401);
                        PrintWriter printWriter = httpServletResponse.getWriter();
                        printWriter.write("{\"error_code\":\"401\",\"message\":\"" + e.getMessage() + "\"}");
            }
        }).permitAll().and().csrf().disable();

        http.addFilterBefore(new VerificationCodeFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
