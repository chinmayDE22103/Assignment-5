package com.example.servlets;

import java.io.IOException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        // Cookie example
        String username = request.getParameter("username");
        if (username != null) {
            Cookie userCookie = new Cookie("username", username);
            response.addCookie(userCookie);
        }
        
        // URL Rewriting
        String sessionUrl = response.encodeURL("session");
        
        // HttpSession
        HttpSession session = request.getSession();
        session.setAttribute("theme", "dark");
        session.setAttribute("language", "en");
        
        response.getWriter().println("Session management demo");
    }
}