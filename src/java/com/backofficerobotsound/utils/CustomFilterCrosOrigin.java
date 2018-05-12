/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backofficerobotsound.utils;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author christophe
 */
@WebFilter(asyncSupported = true, urlPatterns = {"/rest/*"})
public class CustomFilterCrosOrigin implements javax.servlet.Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        System.out.println("test ===============================>>>>>>");
        
        ((HttpServletResponse) response).addHeader("Access-Control-Allow-Origin", "null");
        ((HttpServletResponse) response).addHeader("Access-Control-Allow-Methods", "GET, OPTIONS, HEAD, PUT, POST, DELETE");
        ((HttpServletResponse) response).addHeader("Access-Control-Allow-Headers", "*");
        ((HttpServletResponse) response).addHeader("Access-Control-Max-Age", "86400");

//         ((HttpServletRequest) request).gethaddHeader("Access-Control-Allow-Origin", "*");
//        ((HttpServletRequest) request).addHeader("Access-Control-Allow-Methods", "GET, OPTIONS, HEAD, PUT, POST");
//        ((HttpServletRequest) request).addHeader("Access-Control-Allow-Headers", "Content-Type");
//        ((HttpServletRequest) request).getHeader("");
        
        // pass the request along the filter chain
        chain.doFilter(request, response);
    }

    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }

}