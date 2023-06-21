package com.LibraryMgmt.LibraryMgmtSystem.interceptors;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.LibraryMgmt.LibraryMgmtSystem.models.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class SecurityInterceptor implements HandlerInterceptor {

    
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null && modelAndView.getModel().containsKey("user")) {
            User user = (User) modelAndView.getModel().get("user");

            if (user.getRole().equals("admin")) {
                // Perform admin-specific security checks
                // ...
                System.out.println("SecurityInterceptor: Admin security checks completed.");
            }

            if (user.getRole().equals("librarian")) {
                // Perform librarian-specific security checks
                // ...
                System.out.println("SecurityInterceptor: Librarian security checks completed.");
            }

            if (user.getRole().equals("student")) {
                // Perform student-specific security checks
                // ...
                System.out.println("SecurityInterceptor: Student security checks completed.");
            }
        }
    }
}

