package com.example.servlets;

import java.io.IOException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

public class DatabaseServlet extends HttpServlet {
    private String dbUrl;
    private String dbUser;
    
    @Override
    public void init() {
        // Reading initialization parameters from web.xml
        dbUrl = getServletConfig().getInitParameter("dbUrl");
        dbUser = getServletConfig().getInitParameter("dbUser");
        
        // Store in ServletContext for application-wide access
        getServletContext().setAttribute("dbUrl", dbUrl);
        getServletContext().setAttribute("dbUser", dbUser);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        response.getWriter().println("Database configuration loaded");
    }
} // Added missing closing brace