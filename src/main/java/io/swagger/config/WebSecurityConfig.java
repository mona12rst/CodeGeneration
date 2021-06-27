package io.swagger.config;

import io.swagger.security.JwtTokenFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;




@Component
@EnableWebSecurity // this dude turns on the web security
@EnableGlobalMethodSecurity(prePostEnabled = true) // this needs to be here otherwise wont work
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    private JwtTokenFilter jwtTokenFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.csrf().disable(); // no CSRF protection needed, whatever that means!
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS); // no sessions are needed

        http.authorizeRequests()
                .antMatchers("/users/login")
                .permitAll() // allows some urls for unauthenticated users
                .antMatchers("/users/add")
                .permitAll() // allows some urls for unauthenticated users
                .antMatchers("/h2-console/**/**")
                .permitAll()
                .anyRequest()
                .authenticated(); // prevents any other url for unauthenticated users


        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class); // adds the filter


    }

    @Override
    public void configure(WebSecurity web) throws Exception
    {
        web.ignoring().antMatchers("/h2-console/**/**");
    }

    @Bean
    public AuthenticationManager AuthenticationManagerBean() throws Exception
    {
        return super.authenticationManagerBean();
    }






}
