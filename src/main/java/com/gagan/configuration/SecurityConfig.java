package com.gagan.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Dinesh.Rajput
 *
 */
/* To enable Spring Security integration with Spring MVC add the @EnableWebSecurity annotation to your configuration.*/
@Configuration
@EnableWebSecurity
@ComponentScan({"com.gagan.configuration"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //Override Default configuration in WebSecurityConfigurerAdapter for custom login form and authorize requests
    //We specified multiple URL patterns that any user can access like "/login/".
    //Any URL that starts with "/admin/" will be restricted to users who have the role "ROLE_ADMIN".
    //Any URL that has not already been matched on only requires that the user be authenticated
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/resources/**", "/login").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                    .successHandler(new CustomAuthenticationSuccessHandler());

    }
    //In memory authentication java configuration
    //Not web-specific
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication() //Adds a UserDetailsManagerConfigurer
                //login, password and supported role
                .withUser("user").password("password").roles("USER").and()
                .withUser("admin").password("dinesh").roles("ADMIN");
    }
}
