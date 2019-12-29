package com.yang.boot.security.basic.config.filter;

import com.yang.boot.security.basic.config.authentication.SecurityAuthenticationFailureHandler;
import com.yang.boot.security.basic.exception.VerificationCodeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 19-12-29
 *
 *  Author          : Gavin
 *
 *  Purpose         :  专门用于检验验证码的过滤器;OncePerRequestFilter它可以确保一次请求只会通过一次该过滤器;普通的filter没有这个功能.
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/

@Slf4j
public class VerificationCodeFilter extends OncePerRequestFilter {

    private AuthenticationFailureHandler authenticationFailureHandler = new SecurityAuthenticationFailureHandler();

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        String loginUri = httpServletRequest.getRequestURI();
        log.info("loginUri ----> {} " , loginUri);
        if(!"/login".equalsIgnoreCase(loginUri)){
            filterChain.doFilter(httpServletRequest,httpServletResponse);
        } else {
            try{
                verificationCode(httpServletRequest);
                filterChain.doFilter(httpServletRequest,httpServletResponse);
            }catch (AuthenticationException e){
                e.printStackTrace();
                log.error(e.getMessage(),e);
                authenticationFailureHandler.onAuthenticationFailure(httpServletRequest, httpServletResponse, e);
            }
        }

    }

    public void verificationCode (HttpServletRequest httpServletRequest) throws VerificationCodeException {
        String requestCode = httpServletRequest.getParameter("captcha");
        HttpSession session = httpServletRequest.getSession();
        String savedCode = (String) session.getAttribute("captcha");
        if (!StringUtils.isEmpty(savedCode)) {
            // 随手清除验证码，不管是失败还是成功，所以客户端应在登录失败时刷新验证码
            session.removeAttribute("captcha");
        }
        // 校验不通过抛出异常
        if (StringUtils.isEmpty(requestCode) || StringUtils.isEmpty(savedCode) || !requestCode.equals(savedCode)) {
            throw new VerificationCodeException();
        }
    }
}
