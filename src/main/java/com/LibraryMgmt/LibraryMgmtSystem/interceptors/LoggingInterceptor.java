package com.LibraryMgmt.LibraryMgmtSystem.interceptors;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class LoggingInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Log the incoming request
        System.out.println("LoggingInterceptor: Request received for URL: " + request.getRequestURL().toString());
        return true;
    }

   
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // Log the outgoing response
        System.out.println("LoggingInterceptor: Request processed successfully.");
    }
}

