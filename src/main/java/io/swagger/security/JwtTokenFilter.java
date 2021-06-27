package io.swagger.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.server.ResponseStatusException;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;




@Component
public class JwtTokenFilter extends OncePerRequestFilter
{
    @Autowired
    private JwtTokenProvider jwtTokenProvider;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException
    {
        // get the token from the request
        String token = jwtTokenProvider.resolveToken(request);

        try
        {
            if(token != null && jwtTokenProvider.validateToken(token)) // if the token is not null and is valid
            {
                // create an authentication object that will be returned from the jwt token authenticator using
                // the token that we have
                Authentication auth = jwtTokenProvider.getAuthentication(token); // retrieves the user from the db

                SecurityContextHolder.getContext().setAuthentication(auth); // apply the user to the security context of the request

            }
        }
        catch (ResponseStatusException rse)
        {
            SecurityContextHolder.clearContext(); // if the stuff on top fails, clear everything
            response.sendError(rse.hashCode(), rse.getMessage());
        }

        // happens if the user is authenticated and the catch did not happen (try succeeded)
        // move on to the next level
        chain.doFilter(request, response);

    }
}
