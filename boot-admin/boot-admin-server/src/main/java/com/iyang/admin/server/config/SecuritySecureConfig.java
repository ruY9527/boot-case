/*
package com.iyang.admin.server.config;

// import de.codecentric.boot.admin.server.config.AdminServerProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.context.SaveContextOnUpdateOrErrorResponseWrapper;

*/
/**
 * @Author: Mu_Yi
 * @Date: 2020/6/27 23:24
 * @Version 1.0
 * @qq: 1411091515
 *//*


@Configuration
public class SecuritySecureConfig extends WebSecurityConfigurerAdapter {

    private final String adminContextPath;

    public SecuritySecureConfig(AdminServerProperties adminServerProperties){
        this.adminContextPath = adminServerProperties.getContextPath();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // super.configure(http);
        SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
        successHandler.setTargetUrlParameter("redirectTo");

        http.authorizeRequests().antMatchers(adminContextPath+"/assets/**").permitAll()
                .antMatchers(adminContextPath+"/login").permitAll()
                .anyRequest().authenticated().and()
                .formLogin().loginPage(adminContextPath+"/login").successHandler(successHandler).and()
                .logout().logoutUrl(adminContextPath+"/logout").and().httpBasic().and().csrf().disable();
    }
}
*/
