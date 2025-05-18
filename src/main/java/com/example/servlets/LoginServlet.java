package com.example.servlets;

import java.io.IOException;
import javax.   servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if ("admin".equals(username) && "password".equals(password)) {
            // Store in session
            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            
            // Forward to welcome page
            RequestDispatcher dispatcher = request.getRequestDispatcher("/welcome");
            dispatcher.forward(request, response);
        } else {
            // Redirect back to login with error
            response.sendRedirect("login.html?error=1");
        }
    }
}