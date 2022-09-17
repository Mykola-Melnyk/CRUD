package com.academy.crudforfiledatabase;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "myAccount", value = "/myAccount")
public class MyAccount extends HttpServlet {
    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        HttpSession session = request.getSession();
        String login = (String) session.getAttribute("login");
        String password = (String) session.getAttribute("password");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Your login: " + login + "</h1>");
        out.println("<h1>Your password: " + password + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}