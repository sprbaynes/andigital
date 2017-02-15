package com.angular.spring.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by steven.baynes on 02/02/2016.
 */
public class TimerFilter implements Filter {

    private static final Logger log = LoggerFactory.getLogger(TimerFilter.class);

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest ) req;

        long start = System.nanoTime();
        chain.doFilter(req, res);
        long end = System.nanoTime();
        log.trace( "Duration: {}, Path: {}",
                TimeUnit.NANOSECONDS.toMillis(end - start)+"ms",
                request.getRequestURI()+ ((request.getQueryString() != null)? "?" + request.getQueryString(): "" ) );
    }

    public void init(FilterConfig filterConfig) {}

    public void destroy() {}

}
