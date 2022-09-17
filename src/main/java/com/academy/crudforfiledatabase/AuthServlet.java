package com.academy.crudforfiledatabase;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "login", value = "/login")
public class AuthServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession(true);
        Map<String, Object> authData = JsonReader.convertJson(request);
        String login = (String) authData.get("login");
        String password = (String) authData.get("password");
        if (login != null && password != null) {
            session.setAttribute("login", authData.get("login"));
        }
//        session.setAttribute("password", authData.get("password"));

//        PrintWriter writer = response.getWriter();
//        writer.println("<html><body>");
//        if (session.getAttribute("login") != null && session.getAttribute("password") != null) {
//            writer.println("<h1>Login success</h1>");
//        } else {
//            writer.println("<h1>Authorization failed. Login and password must not be empty!</h1>");
//        }
//        writer.println("</body></html>");
    }

    public void destroy() {
    }
}
