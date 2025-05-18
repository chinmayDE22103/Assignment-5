package com.example.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Get query parameters
        String name = request.getParameter("name");
        
        // Get client details
        String ipAddress = request.getRemoteAddr();
        String userAgent = request.getHeader("User-Agent");
        
        out.println("<html><body>");
        out.println("<h2>Welcome to Servlet Demo</h2>");
        out.println("<p>Name: " + (name != null ? name : "Guest") + "</p>");
        out.println("<p>IP Address: " + ipAddress + "</p>");
        out.println("<p>User Agent: " + userAgent + "</p>");
        out.println("</body></html>");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        doGet(request, response);
    }
}