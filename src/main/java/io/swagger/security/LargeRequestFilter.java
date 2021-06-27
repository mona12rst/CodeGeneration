package io.swagger.security;


import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;


@Log
@Component
@Order(1)
public class LargeRequestFilter implements Filter {
    @Value("${banking.max.request.size}")
    private int maxSize;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

//        log.info(String.format("max request size: %d", maxSize));




        int requestSize = request.getContentLength();

        if(requestSize > maxSize)
        {
        log.fine(String.format("request size: %d", requestSize));

            throw new ServletException("Request is too big");

        }
        else
        {
            chain.doFilter(request, response);
        }
    }
}
